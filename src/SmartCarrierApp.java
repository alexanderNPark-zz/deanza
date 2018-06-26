// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  SmartCarrierApp.java

//  Program purpose: To Start and initialize the SmartCarrier Object

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/25/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class SmartCarrierApp {

    public static void main(String[] arg){
        SmartCarrier sm = new SmartCarrier();
        sm.initialize();
        sm.run();
    }
}
