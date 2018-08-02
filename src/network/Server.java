package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by AlexP on 7/28/2017.
 */
public class Server {

    private int port = 2334;
    private String delimiter = "#<0/Exit0>";
    private String endCommand = "exit";
    private Scanner scan;
    private InputStream curIn;
    private OutputStream curOut;
    private BufferedReader br;
    private PrintWriter pw;
    private int img_port;
    private HashMap<String,ITReceiver> DELIMITER_TABLE = new HashMap<>();



    public void initializeDelimiter(){
        ITReceiver s = new ITReceiver();
        DELIMITER_TABLE.put("#<0/Exit0>", s);
        DoneReceiver dr = new DoneReceiver();
        DELIMITER_TABLE.put("#<done>",dr);
    }

    public static void main(String[] args){
        Server t = new Server();
        t.start();
    }

    public void initializeStreams(){
         br = new BufferedReader(new InputStreamReader(curIn));
         pw = new PrintWriter(curOut);
         Iterator<String> iter = DELIMITER_TABLE.keySet().iterator();
         while(iter.hasNext()){
             ITReceiver it = DELIMITER_TABLE.get(iter.next());
             it.setBr(br);
             it.setIs(curIn);
         }

    }

    public void start(){
        img_port = port +1;
        ImageServer im = new ImageServer(img_port);
        //start new thread with ImageServer
        Thread t = new Thread(im);
        t.start();
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
        }catch (Exception e){}
        scan = new Scanner(System.in);
        initializeDelimiter();
        boolean sentProperly = true;
        String lastCommand = "";
        Socket server=null;
        while(true){

            try {
                server = ss.accept();
                System.out.println("RECEIVING");
                while(true) {

                    if (sentProperly) {
                        lastCommand = promptCommand();
                        if (lastCommand.equals("reboot")) {
                            sentProperly = true;
                            server.close();
                            break;
                        }

                    }
                    sentProperly = false;
                    curIn = server.getInputStream();
                    curOut = server.getOutputStream();
                    initializeStreams();


                    sendCommand(lastCommand);

                    //System.out.println(readUntilGone());
                    chooseDelimAndExecute();
                    sentProperly = true;
                }


            } catch (IOException e) {
                continue;
            }
        }

    }

    public String readUntilGone() throws IOException{
        String line = "";
        String content = "";
        while ((line = br.readLine())!= null && !(line.equals(delimiter)))content+=line+"\n";
        if(line==null){
            throw new IOException("DCED");
        }
        return content.replace(delimiter,"");
    }

    public void sendCommand(String command) throws IOException{

        pw.println(command);
        pw.println(delimiter);
        if (command.equals("screen")) {
            pw.println(img_port);
            pw.println(delimiter);
        }
        pw.flush();


    }

    public void sendEndCommand(){
        pw.println(endCommand);
        pw.println(delimiter);
        pw.flush();
    }


    public void chooseDelimAndExecute() throws IOException {

        String token = br.readLine();
        if(token==null){
            throw new IOException("NULL DELIMTER");
        }
        ITReceiver parser = DELIMITER_TABLE.get(token);
        if(parser==null){
            System.out.println(token);
            return;
        }
        String result = parser.readLineUntilDelimString();
        if(result==null){
            throw new IOException("Fucked up");
        }
        System.out.println(result);

    }





    public String promptCommand(){
        System.out.print("Enter Command:");
        return scan.nextLine();
    }


}
