package network;
import static java.lang.Thread.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by AlexP on 7/28/2017.
 */
public class Server {

    private ServerSocket server=null;
    private InputStream is=null;
    private PrintWriter pw = null;
    public void start() {
        while (true) {
            try {
                server = new ServerSocket(2334);
                Socket s = server.accept();
                InputThread it = new InputThread(s.getInputStream());
                OutputThread ot = new OutputThread(s.getOutputStream());

                Thread input = new Thread(it);
                input.start();
                Thread output = new Thread(ot);
                output.start();

            }catch(Exception e){
                continue;
            }
        }


    }


}
