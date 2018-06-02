// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Customer.java

//  Program purpose: A class encapsulating Customer Data

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   05/15/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by AlexP on 5/14/2018.
 */
public class Customer {


    private String name,cardNumber = "";
    private int totalBalance;
    private int rewardBalance=0;
    private Transaction[] transactions;
    private Rewardable[] rewards;

    private static int DEFAULT_LENGTH = 16;

    public Customer(){
        name = "John Doe";

        transactions = new Transaction[DEFAULT_LENGTH];
        rewards = new Rewardable[DEFAULT_LENGTH];
    }

    public Customer(String _name,String _cardNumber,int _balance, int _rewardBalance){
        name = _name;
        cardNumber = _cardNumber;
        totalBalance = _balance;
        rewardBalance = _rewardBalance;
        transactions = new Transaction[DEFAULT_LENGTH];
        rewards = new Rewardable[DEFAULT_LENGTH];
    }

    public void readTransactions(String fileName){
        /**
         * Reads transactions from card.txt
         */
        try{
            FileInputStream fis = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            int index = 0;
            int rIndex = 0;
            while(true){
                String line = br.readLine();
                if(line==null) break;
                String[] tokens = line.split("~");
                switch(tokens[0]){
                    case "DS":
                        transactions[index++] = new DepartmentStoreTransaction(tokens[4],Integer.parseInt(tokens[2])
                                                                             , tokens[1], Double.parseDouble(tokens[3]),tokens[5]);
                        break;
                    case "BK":transactions[index++] = new BankingTransaction(tokens[4],Integer.parseInt(tokens[2])
                            , tokens[1], Double.parseDouble(tokens[3]),Double.parseDouble(tokens[5]));
                        break;
                    case "GR":transactions[index++] = new GroceryTransaction(tokens[4],Integer.parseInt(tokens[2])
                            , tokens[1], Double.parseDouble(tokens[3]));
                        break;

                }

                if(transactions[index-1] instanceof Rewardable){
                    rewards[rIndex++] =(Rewardable) transactions[index-1];

                }
            }

            br.close();

        }catch(Exception fe){
            fe.printStackTrace();
        }
    }

    public void reportTransactions(){
        /**
         * Reports all transactions from file
         */
        System.out.println("\t\t\tTRANSACTIONS LIST REPORT");
        for(int i =0; i<DEFAULT_LENGTH;i++){
            if(transactions[i]==null)break;
            System.out.println(transactions[i].list());
        }
        System.out.println();
        System.out.println();
    }

    public void reportCharges(){
        /**
         * reports all charges
         *
         */
        int totalCharges = 0;
        for(int i=0;i<DEFAULT_LENGTH;i++){
            if(transactions[i] instanceof BankingTransaction){
                totalCharges+=((BankingTransaction) transactions[i]).getCharge();
            }
        }

        System.out.println("Total Charges:"+totalCharges);

        System.out.println();
        System.out.println();
    }


    public void reportRewardSummary(){
        /**
         * Reports the summary of customer transactiosn
         *
         *
         */
        System.out.println("Rewards Summary for "+name+" "+cardNumber.substring(cardNumber.length()-4));
        System.out.println("Previous points balance "+rewardBalance);
        int departPoints =0;
        int groceryPoints=0;

        for(int i = 0;i<DEFAULT_LENGTH;i++){
            if(rewards[i]==null)break;
            if(rewards[i] instanceof DepartmentStoreTransaction){
                departPoints+=rewards[i].earnPoints();
            }
            if(rewards[i] instanceof GroceryTransaction){
                groceryPoints+=rewards[i].earnPoints();
            }

        }

        System.out.printf("%-45s%10d \n","+ Points earned on Department store purchases",departPoints);
        System.out.printf("%-45s%10d \n","+ Points earned on Grocery store purchases",groceryPoints);
        System.out.println("------------------------------");
        System.out.printf("%-45s%10d \n","= Total points available for redemption",rewardBalance = rewardBalance+departPoints+groceryPoints);
        System.out.println();
        System.out.println();


    }




}
