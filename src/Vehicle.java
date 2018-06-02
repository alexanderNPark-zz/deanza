// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Vehicle.java

//  Program purpose: A class encapsulating Vehicle Data

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   04/22/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class Vehicle {

    //private instance attributes
    private String make, model;
    private int year;
    private double price;
    private boolean reserved;

    //default constructor
    public Vehicle(){
        make = "";
        model = "";
        year = 0;
        price = 0;
    }

    //non-default constructor
    public Vehicle(String _make, String _model, int _year, double _price){
        make = _make;
        model = _model;
        year = _year;
        price = _price;
        reserved = false;

    }

    // prints out as string
    public String toString(){
        return make+" "+ model+";"+year+";$ "+price;
    }

    //all the mutator methods including adjusted EC

    public Vehicle setMake(String make){
        this.make = make;
        return this;
    }

    public Vehicle setModel(String model){
        this.model = model;
        return this;
    }

    public Vehicle setYear(int year){
        this.year = year;
        return this;
    }

    public Vehicle setPrice(double price){
        this.price = price;
        return this;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    // ALL the accessor methods

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isReserved() {
        return reserved;
    }


}
