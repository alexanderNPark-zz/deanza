import java.io.*;
import java.util.function.Function;

import static java.lang.System.out;
import static java.lang.Math.sqrt;

public class Test {

    public static void main(String[] args) {
        int i=3;
        i*=0.1;
        System.out.println(i);
    }

    public static void etest(int[] array){
        for(int i=1; i<array.length;i++){
            int index = i;
            while(index>0 && array[index]<array[index-1]){
                int temp = array[index];
                array[index] = array[index-1];
                array[index-1] = temp;
                index--;
            }
        }


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
