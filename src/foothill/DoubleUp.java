package foothill;

import java.util.Scanner;

/**
 * Created by AlexP on 1/21/2018.
 */
public class DoubleUp {

    private int val;
    private int total;

    public static void main(String[] args){
        DoubleUp db = new DoubleUp();
        db.input();
        db.calculate();
        db.displayTotal();
    }

    public void input(){
        Scanner scan = new Scanner (System.in);
        while(true) {
            System.out.print("Number: ");
            this.val = scan.nextInt();
            if(!(this.val<=0 || this.val>20)){
                break;
            }
            else{
                System.out.println("ERROR");
            }
            System.out.println();
        }

    }

    public void calculate(){
        for(int i = 1; i<=val;i++){
            total+=2*i;
            System.out.println("Double up "+i+" = "+2*i);
            System.out.println();
        }
    }

    public void displayTotal(){
        System.out.println("Total = "+total);
    }
}
