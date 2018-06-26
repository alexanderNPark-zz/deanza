// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Message.java

//  Program purpose: This class extends the item class and contains specific data about the item via text, voice, media

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/25/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
public class Message<T> extends Item{

    private T data;

    public Message(){
        data =null;
    }

    public Message(T _data, int _time, String _from, String _to, double _charge ){
        super(_time,_from,_to,_charge);
        data = _data;
    }

    @Override
    public String toString() {
        return String.format("%-65s",data.toString())+String.format("%-65s",super.toString());
    }

    //getters and setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
