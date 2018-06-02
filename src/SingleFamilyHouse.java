/**
 * Created by AlexP on 5/31/2018.
 */
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
