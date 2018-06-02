import java.io.*;
import java.util.Calendar;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.search(new File("C:/deanza"));
    }

    public boolean checkCPP(String name){
        return name.endsWith(".cpp")? true : false;
    }

    public void search(File fileName){
        if(fileName.isDirectory()){
            File[] files = fileName.listFiles();
            for (File f: files ){
                search(f);
            }
        }
        else{
            if(checkCPP(fileName.getName())){
                try {
                    FileInputStream fis = new FileInputStream(fileName);
                    ByteArrayOutputStream baos =new ByteArrayOutputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    byte[] bucket =null;
                    String line = "";
                    int count = 5;
                    while(true){
                        line = br.readLine();
                        if(line==null)break;
                        if(count==5) {
                            if (line.contains("**Stamped**")) return;
                        }
                        bucket = (line+="\n").getBytes();
                        baos.write(bucket);
                        count++;
                    }
                    fis.close();
                    baos.flush();
                    baos.close();
                    byte[] content = baos.toByteArray();

                    FileOutputStream fos = new FileOutputStream(fileName);
                    PrintWriter pw = new PrintWriter(fos);
                    pw.println("/***Stamped***\n*Alexander Park \n*alexincupertino@gmail.com\n*" + getToday() + "\n*/");
                    pw.print(new String(content));
                    pw.flush();
                    pw.close();
                }catch (Exception e){
                    e.printStackTrace();;
                }

            }
        }

    }

    public String getToday(){
        LocalDate localDate = LocalDate.now();
        return DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate);
    }
}
