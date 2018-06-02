package network.messing;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.System.out;
/**
 * Created by AlexP on 2/16/2018.
 */
public class Asm {

    private ArrayList<Integer> instructions = new ArrayList<Integer>();
    private HashMap<String, Format_Type> match = new HashMap<>();


    public void extract(File f){
        try {
            FileInputStream fis = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            while(true){
                String line = br.readLine().trim();
                if(line==null){
                    break;
                }
                String instruction = line.substring(0,line.indexOf(' '));
                String rest_args  = line.substring(line.indexOf(' ')+1);

            }
        }catch(Exception e){

        }

    }

    public void trigger(String instruction, String rest_args){
        Format_Type type = match.get(instruction);


    }



    public void parse_R(){

    }




}
