// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  BankingTransaction.java

//  Program purpose: A class encapsulating Banking Transaction Data

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   05/15/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class BankingTransaction extends Transaction{

    private String name;
    private double charge;

    public BankingTransaction(){

    }

    public BankingTransaction(String _name, int id, String date, double am, double service){
        super(id, date, am);
        name = _name;
        amount+=service;
        charge = service;
    }

    @Override
    public String list() {
        return String.format("%-10s %-20s %-15s $%-10f", transactionDate,"Banking",name+" withdraw",amount);
    }

    //neccesary mutators and accessors
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCharge(){
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            if(obj instanceof BankingTransaction){
                return ((BankingTransaction) obj).name == name;
            }
        }
        return false;
    }
}
