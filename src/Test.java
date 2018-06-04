import java.io.*;

import static java.lang.System.out;

public class Test {

    public static void main(String[] args)
    {
        etest();
    }

    public static void etest(){
       
    }

    public static void test(){
        try {
            FileInputStream fis = new FileInputStream(new File("C:/61C/go.txt"));
            String sentence="";
            while(true){
                int byte_read = fis.read();
                if(byte_read==32) {
                    break;
                }
                sentence+=(char)byte_read;

            }
            fis.close();
            System.out.println(sentence);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2(){
        try {
            RandomAccessFile raf = new RandomAccessFile(new File("C:/61C/go.txt"),"r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   public static void hanoi(int nDisks, char start,char temp,char target){
        if(nDisks==1){
            System.out.println("Moved Top Disk from "+start+" to "+target);
        }
        else{
            hanoi(nDisks-1, start, target,temp);
            hanoi(1,start,temp,target);
            hanoi(nDisks-1, temp,start,target);
        }
   }


}
