package network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{

    private InputStream is;
    private OutputStream os;

    public static void main(String[] args){

        try(Socket s = new Socket("localhost",2334)){
            OutputStream os = s.getOutputStream();
            Thread input = new Thread(new Client(s.getInputStream(),os));
            input.start();
            Scanner scan = new Scanner(System.in);
            while(true){
                String content  = scan.nextLine();
                System.out.println(content);
                os.write((content+"\n").getBytes());
                os.flush();


            }
        }catch(Exception e){
            System.out.println("DEAD");
        }
    }

    public Client(InputStream readSocket, OutputStream os){
        is = readSocket;
        this.os = os;
    }

    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=br.readLine())!=null){
                if(line.contains("<exit>")){
                    is.close();
                    os.close();
                    System.exit(0);
                }
                System.out.println(line);
            }
        }catch (Exception e){

        }
    }
}
