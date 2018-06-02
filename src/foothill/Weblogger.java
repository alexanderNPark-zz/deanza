package foothill;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by AlexP on 3/1/2018.
 */
public class Weblogger {
    private String[] lines = new String[2990];
    private File access;
    private Scanner accessor;
    private int counter = 0;

    public Weblogger(String file_name){
        access = new File(file_name);
        try {
            accessor = new Scanner(access);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public boolean readLine(){

        if(accessor.hasNext()) {
            lines[counter] = accessor.nextLine();
            counter++;
            return true;
        }

        return false;

    }

    public void sort_write(){
        Arrays.sort(lines);
        try {
            PrintWriter pw = new PrintWriter(new File("new_weblog.txt"));
            for(String elem:lines){
                pw.println(elem);
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Holder{
    public static void main(String[] args){
        Weblogger wb = new Weblogger("weblog.txt");
        while(wb.readLine());
        wb.sort_write();
    }

}