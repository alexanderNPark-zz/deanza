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
    private  HashMap<String,ITReceiver> DELIMITER_TABLE = new HashMap<>();



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


        while(true){
            Socket server=null;
            try {
                server=ss.accept();
                curIn = server.getInputStream();
                curOut = server.getOutputStream();
                initializeStreams();

                String command = "";
                while(!((command = promptCommand()).equals(endCommand))){
                    sendCommand(command);
                    chooseDelimAndExecute();
                }
                sendEndCommand();
                server.close();
            } catch (IOException e) {
                System.out.println("Disconnected");
                continue;
            }
        }

    }

    public void sendCommand(String command){
        pw.println(command);
        pw.println(delimiter);
        if(command.equals("screen")){
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
        ITReceiver parser = DELIMITER_TABLE.get(token);
        System.out.println(parser.readLineUntilDelimString());

    }



    public String promptCommand(){
        System.out.print("Enter Command:");
        return scan.nextLine();
    }


}
