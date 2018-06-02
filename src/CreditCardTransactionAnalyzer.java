// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  CreditCardTransactionAnalyzer.java

//  Program purpose: A class starting the program

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   05/15/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class CreditCardTransactionAnalyzer {

    public static void main(String[] args){
        Customer c = new Customer("Gopher", "123456789",0,0);
        c.readTransactions("card.txt");
        c.reportTransactions();
        c.reportCharges();
        c.reportRewardSummary();
    }
}
