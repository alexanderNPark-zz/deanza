import java.io.PrintWriter;

/**
 * Created by AlexP on 5/31/2018.
 */
public class Property {


    private String address;
    private double offeredPrice;
    private int yearBuilt;
    private Property next = null;


    public Property(){
        address=  "";
        offeredPrice = 0.0;
        yearBuilt = 0;
    }

    public Property(String address, double offeredPrice, int yearBuilt){
        this.address = address;
        this.yearBuilt = yearBuilt;
        this.offeredPrice = offeredPrice;


    }

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
