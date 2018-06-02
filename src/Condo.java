import foothill.DoubleUp;

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
