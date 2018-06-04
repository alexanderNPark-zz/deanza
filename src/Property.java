// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Condo.java

//  Program purpose: Property for all property types

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/1/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class Property {

    //attributes
    private String address;
    private double offeredPrice;
    private int yearBuilt;
    private Property next = null;

    //default constructor
    public Property(){
        address=  "";
        offeredPrice = 0.0;
        yearBuilt = 0;
    }

    //non-default constructor
    public Property(String address, double offeredPrice, int yearBuilt){
        this.address = address;
        this.yearBuilt = yearBuilt;
        this.offeredPrice = offeredPrice;


    }

    //accessors, mutators, and overrided equals and toString methods

    public void setNext(Property next){
        this.next = next;
    }

    public Property getNext(){
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Property && ((Property)obj).offeredPrice ==this.offeredPrice
                                       && ((Property)obj).yearBuilt==this.yearBuilt;
    }

    public double getOfferedPrice() {
        return offeredPrice;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {

        return String.format("%-47s $%-12.2f %-8d",address,offeredPrice,yearBuilt);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}
