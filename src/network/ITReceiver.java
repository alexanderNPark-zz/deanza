package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ITReceiver {


    private BufferedReader br;
    private InputStream is;
    protected String delimiter = "#<0/Exit0>";

    public ITReceiver(){

    }

    public String readLineUntilDelimString(){
        try {
            String content = "";
            String line = "";
            while ((line = br.readLine())!= null && !(line.equals(delimiter)))content+=line+"\n";
            if(line==null){
                return null;
            }
            return content;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Disconnected");
            return "";
        }
    }

    public String readLineUntilDelimString(String customDelimiter){
        try {
            String content = "";
            String line = "";
            while ((line = br.readLine())!= null && !(line.equals(customDelimiter)))content+=line;
            if(line==null){
                return null;
            }
            return content;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Disconnected");
            return "";
        }
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public InputStream getIs() {
        return is;
    }

    public BufferedReader getBr() {
        return br;
    }
}
