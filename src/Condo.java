// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Condo.java

//  Program purpose: Subclass of property for type Condos, has homeowners association fee

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/1/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------

/**
 * Created by AlexP on 5/31/2018.
 */
public class Condo extends Property {
    private double hOAfee;

    public Condo(){
        super();
        hOAfee = 100;
    }

    public Condo(String address, String offeredPrice, String yearBuilt, String extra){
        super(address, Double.parseDouble(offeredPrice),Integer.parseInt(yearBuilt));
        hOAfee = Double.parseDouble(extra);
    }

    public String toString(){
        return super.toString()+"HOAfee:$"+String.format("%-10.2f",hOAfee);
    }

    public double gethOAfee() {
        return hOAfee;
    }

    public void sethOAfee(double hOAfee) {
        this.hOAfee = hOAfee;
    }
}
