// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Item.java

//  Program purpose: This class is an object holder for overlapping data information per item on the file

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/25/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class Item {


    private int time;
    private String from,to;
    private double charge;

    public Item(){
        time=0;
        from = null;
        to=null;
        charge = 0;
    }

    public Item(int _time, String _from, String _to, double _charge ){
        time = _time;
        from = _from;
        to = _to;
        charge = _charge;
    }


    //all accessors and mutators
    public double getCharge() {
        return charge;
    }

    public int getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setTo(String to) {
        this.to = to;
    }


    @Override
    public String toString() {
        return "Time:"+time+", From:"+from+", To:"+to;
    }
}
