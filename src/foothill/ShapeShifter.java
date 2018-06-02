package foothill;

/**
 * Created by AlexP on 1/9/2018.
 */
public class ShapeShifter {



    public static void main(String[] arg){
        Shapes ss = new Shapes();

        System.out.println("Vertical Line:");
        ss.drawVerticalLine();
        System.out.println("Rectangle:");
        ss.drawRectangle();
        System.out.println("Triangle:");
        ss.drawTriangle();
        System.out.println("Festive Tree:");
        ss.drawTriangle();
        ss.drawTriangle();
        ss.drawVerticalLine();
        System.out.println("House:");
        ss.drawTriangle();
        ss.drawRectangle();
        System.out.println("Beaker:");
        ss.drawVerticalLine();
        ss.drawTriangle();
        System.out.println("Popsicle:");
        ss.drawRectangle();
        ss.drawVerticalLine();

    }


}

class Shapes {
    int max_length = 7;
    String minimum_padding = " ";

    public void drawVerticalLine() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" ");
            }
            System.out.println(minimum_padding + "*");
        }
    }
    private void horizontalLine(){

        System.out.print(minimum_padding);
        for (int i = 0; i < max_length; i++) System.out.print("*");
        System.out.println();
    }

    public void drawRectangle() {
        horizontalLine();

        for (int i = 0; i < 3; i++) System.out.println(minimum_padding + "*     *");

        horizontalLine();
    }

    public void drawTriangle() {
        recur(1,5);

        horizontalLine();

    }

    private void recur(int begin, int end){
        if(begin==end){
            System.out.print(minimum_padding);
            for(int i=0;i<begin;i++)System.out.print(" ");
            System.out.print("*");
            for(int i=0;i<end;i++)System.out.print(" ");
            System.out.println();
        }
        else{
            recur(begin+1,end-1);
            System.out.print(minimum_padding);
            for(int i=0; i<max_length;i++){
                if(i==begin ||  i==end){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
