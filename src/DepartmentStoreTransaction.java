// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:   DepartmentStoreTransaction.java

//  Program purpose: A class encapsulating Department Store Transaction  Data

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   05/15/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class DepartmentStoreTransaction extends Transaction implements Rewardable {

    private String name;
    private String days;

    @Override
    public int earnPoints() {
        return (int)(3*amount);
    }

    public DepartmentStoreTransaction(){

    }

    public DepartmentStoreTransaction(String _name, int id, String date, double am, String _days){
        super(id, date, am);

        name = _name;
        days = _days;
    }

    @Override
    public String list() {
        return String.format("%-10s %-20s %-15s $%-10f  %s", transactionDate,"Department Store",name,amount,"(return in "+days+" days)");
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            if(obj instanceof DepartmentStoreTransaction){
                return ((DepartmentStoreTransaction) obj).name == name;
            }
        }
        return false;
    }

    //accessors and mutators

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
