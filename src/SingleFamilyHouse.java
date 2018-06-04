// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Condo.java

//  Program purpose: Subclass of property for type SFH has backyard

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/1/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class SingleFamilyHouse extends Property{

    private int backyardSize;

    public SingleFamilyHouse(){
        super();
        backyardSize = 0;
    }

    public SingleFamilyHouse(String address, String offeredPrice, String yearBuilt, String extra){
        super(address, Double.parseDouble(offeredPrice),Integer.parseInt(yearBuilt));
        backyardSize = Integer.parseInt(extra);
    }

    //accessors and mutators
    public int getBackyardSize() {
        return backyardSize;
    }

    public void setBackyardSize(int backyardSize) {
        this.backyardSize = backyardSize;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("%-10s",backyardSize+"(sqft)");
    }
}
