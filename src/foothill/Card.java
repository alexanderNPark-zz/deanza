package foothill;

/**
 * Created by AlexP on 2/23/2018.
 */
public class Card {

    private String message="";
    private String name_rec = "";
    private String name_send = "";
    private static int CARD_COUNT_TOTAL = 0;
    private int card_num = 0;
    private String occasion ="";

    public Card(String _name_rec, String _name_send, String message, String occasion){
        CARD_COUNT_TOTAL+=1;
        card_num = CARD_COUNT_TOTAL;
        name_rec=_name_rec;
        name_send = _name_send;
        this.message = message;
        this.occasion = occasion;

    }

    public Card(String _name_rec, String _name_send){
        name_send = _name_send;
        name_rec = _name_rec;
    }

    public String getMessage(){
        return message;
    }
    public String getRecipient(){
        return name_send;
    }
    public int getCount(){
        return card_num;
    }

    public void printMessage(){
        System.out.println("Happy "+occasion+" "+name_rec+"!\n"+message+"\nFrom "+name_send);
        System.out.println();
    }

    public void setMessage(String _message){
        message = _message;
    }
    public void setOccasion(String occ){
        occasion = occ;
    }

    public static int getTotalCount(){
        return CARD_COUNT_TOTAL;
    }

    public void setName(String newName){
        name_rec = newName;
    }
}

class Main{
    public static void main(String[] arg){

        Card c = new Card("John","Harry","Have a great Day!","Birthday");
        c.printMessage();

        Card c2 = new Card("Tom", "Dick");
        c2.setMessage("I am not your son.");
        c2.setOccasion("Father's Day");
        c2.printMessage();
    }
}
