package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProcessAct {

    public static void main(String[] args){
        try {
            Process p = Runtime.getRuntime().exec("dir");
            InputStream is = p.getInputStream();
            OutputStream os = p.getOutputStream();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
