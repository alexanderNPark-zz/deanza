package network;


import network.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageServer implements Runnable{

    private int port;
    private ServerSocket ss;
    private int imageIndex=0;

    public ImageServer(int port){
        this.port = port;
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        Socket imageSender= null;
        while (true) {
            try {
                imageSender  = ss.accept();
                read(imageSender.getInputStream());
                imageSender.close();
            }catch (Exception e){
                continue;
            }
        }

    }

    public void read(InputStream is){
        try {
            FileOutputStream fos = new FileOutputStream(new File(buildPathName()));
            byte[] bucket = new byte[1000];
            int read =0;
            while((read = is.read(bucket))!=-1){
                fos.write(bucket,0,read);
            }
            fos.flush();;
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String buildPathName(){
        String path = "./"+(new SimpleDateFormat("MM_dd_yyyy").format(new Date()))+"/";
        File dir = new File (path);
        if(!dir.exists()){
            dir.mkdir();
        }
        String time = new SimpleDateFormat("hh_mm_a").format(new Date());
        return path+time+"_image"+(imageIndex++)+".png";

    }
}
