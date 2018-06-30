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
            return content;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }
}
