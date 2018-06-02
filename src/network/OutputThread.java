package network;

import java.io.OutputStream;

/**
 * Created by AlexP on 7/30/2017.
 */
public class OutputThread implements Runnable{

    OutputStream os = null;

    public OutputThread(OutputStream _os){
        os=_os;
    }

    public void run() {

    }
}
