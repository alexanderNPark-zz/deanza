// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name: GroceryTransaction.java

//  Program purpose: A class encapsulating Grocery TransactionData

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   05/15/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class GroceryTransaction extends Transaction implements Rewardable{

    private String name;

    @Override
    public int earnPoints() {
        return (int) (5*amount);
    }

    public GroceryTransaction(){

    }

    public GroceryTransaction(String _name, int id, String date, double am){
        super(id, date, am);
        name = _name;
    }

    @Override
    public String list() {
        return String.format("%-10s %-20s %-15s $%-10f", transactionDate,"Grocery",name,amount);
    }

    public boolean equals(Object obj) {
        if(super.equals(obj)){
            if(obj instanceof GroceryTransaction){
                return ((GroceryTransaction) obj).name == name;
            }
        }
        return false;
    }

    //accessors and mutators
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
