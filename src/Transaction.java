// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Transaction.java

//  Program purpose: A class encapsulating Transaction Data

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   05/15/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public abstract class Transaction {

    //attributes
    private int transactionID;

    protected String transactionDate;
    protected double amount;

    public Transaction(){

    }

    public Transaction(int id, String date, double am){
        transactionDate = date;
        transactionID = id;
        amount = am;
    }

    public abstract String list();

    // all accessors and mutators
    public String toString(){
        return transactionID+" "+transactionDate+" "+amount;
    }

    public double getAmount() {
        return amount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Transaction)){
            return false;
        }
        Transaction t = (Transaction) obj;
        return transactionID == t.transactionID && transactionDate == t.transactionDate;
    }
}
