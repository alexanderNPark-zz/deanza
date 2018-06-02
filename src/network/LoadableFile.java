package network;

import java.io.*;

/**
 * Created by AlexP on 7/30/2017.
 */
public class LoadableFile {

    private File f;
    private byte[] file;
    private String name = "";

    public LoadableFile(String path){
        f = new File(path);
        load();
    }

    public void load(){
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bucket = new byte[1000];
            int read = 0;
            while((read=fis.read(bucket))!=-1){
                baos.write(bucket,0,read);
            }
            fis.close();
            baos.flush();
            baos.close();
            file = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(OutputStream os){
        PrintWriter pw = new PrintWriter(os);
        pw.println("<name?>"+name+"</name?>");
        pw.flush();
        try {
            if(file!=null) {
                os.write(file);
                os.flush();
                pw.println("<FINISHED?>");
                pw.flush();;
            }
            else{
                System.out.println(name+" NOT LOADED");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
