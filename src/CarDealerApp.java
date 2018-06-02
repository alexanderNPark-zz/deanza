// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  CarDealerApp.java

//  Program purpose: Test Cases and Run CarDealer as it is in order.

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   04/22/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class CarDealerApp {

    public static void main(String[] arg){
        CarDealer car_dealer = new CarDealer("Hell");
        car_dealer.init(); //load data first
        car_dealer.run();//then perform search, inventory etc.
    }
}
