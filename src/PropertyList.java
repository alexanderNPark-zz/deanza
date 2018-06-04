// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  PropertyList.java

//  Program purpose: A LinkedList (non-generic) that collects properties from the txt file and loads them for the prog.

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/1/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by AlexP on 5/31/2018.
 */
public class PropertyList {

    Property head;

    public PropertyList(){
        head = null;
    }

    public void insert(Property newHead){
        newHead.setNext(head);
        head = newHead;
    }

    public void initialize(){
        try {
            FileInputStream fis = new FileInputStream(new File("props.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while(true){
                String line = br.readLine();
                if(line==null){
                    break;
                }
                setAndBuild(line.split(";"));

            }
            br.close();
        }catch(Exception e){

        }
    }

    // builds "Property" object using the tokens from file and puts it in front of linked list
    public void setAndBuild(String[] tokens){
        if(tokens[0].equalsIgnoreCase("condo")){
            insert(new Condo(tokens[1],tokens[2],tokens[3],tokens[4]));
        }
        else if (tokens[0].equalsIgnoreCase("sfh")){
            insert(new SingleFamilyHouse(tokens[1],tokens[2],tokens[3],tokens[4]));
        }

    }


    //gets all property data from linked list
    public String getAllProperties(){
        String result = "";
        Property temp = head;
        while(temp.getNext()!=null){
            result+=temp.toString()+"\n";
            temp = temp.getNext();
        }
        return result+temp.toString();
    }

    //gets all condos from property data
    public String getCondo(){
        String result = "";
        Property temp = head;
        while(temp!=null){
            if(temp instanceof Condo){
                result+=temp.toString()+"\n";
            }
            temp = temp.getNext();
        }
        return result;
    }

    //gets all SFH from property data
    public String getSingleFamilyHouse(){
        String result = "";
        Property temp = head;
        while(temp!=null){
            if(temp instanceof SingleFamilyHouse){
                result+=temp.toString()+"\n";
            }
            temp = temp.getNext();
        }
        return result;
    }

    //gets all properties within given price range
    public String searchbyPriceRange(double min, double max){
        String result = "";
        Property temp = head;
        while(temp!=null){
            if(temp.getOfferedPrice()>= min && temp.getOfferedPrice()<=max){
                result+=temp.toString()+"\n";
            }
            temp = temp.getNext();
        }
        return result;
    }

}
