package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by AlexP on 7/31/2017.
 */
public class InputThread implements Runnable{

    BufferedReader br;

    public InputThread(InputStream is){
        br = new BufferedReader(new InputStreamReader(is));
    }

    public void run() {
        try {
            String line = "";
            while (line!=null && !(line = br.readLine()).equals("</Exit>")) {
                switch(line){
                    case "":;
                }
            }
        }
        catch(Exception e){

        }
    }
}
