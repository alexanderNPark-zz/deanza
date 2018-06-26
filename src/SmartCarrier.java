// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  SmartCarrier.java

//  Program purpose: This class is used to hold the data of all phone numbers and stores it in an arraylist
//                   as well as provides an interface to the user for accessing such data

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/25/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SmartCarrier {
    private HashMap<String, ArrayList<Message<?>>> smartData = new HashMap<String, ArrayList<Message<?>>>();


    //initializes SmartCarrier
    public void initialize(){
        try {
            FileInputStream fis = new FileInputStream(new File("listing.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while(true){
                String line = br.readLine();

                if(line==null){
                    break;
                }
                setAndBuild(line.split(","));

            }
            br.close();
        }catch(Exception e){
            System.out.println("No Such File");
        }
    }

    //parses tokens from file and creates message object with given type
    private void setAndBuild(String[] tokens){
        //message type,time,from,to,<message-specific data)
        Message<?> m = null;
       switch(tokens[0].replace(" ","")){
           case "T":
               m = new Message<Text>(new Text(tokens[4]), Integer.parseInt(tokens[1]), tokens[2],tokens[3],Double.parseDouble(tokens[tokens.length-1]));
               break;
           case "V":
               m = new Message<Voice>(new Voice(Integer.parseInt(tokens[4]),tokens[5]), Integer.parseInt(tokens[1]), tokens[2],tokens[3],Double.parseDouble(tokens[tokens.length-1]));

               break;
           case "M":
                m = new Message<Media>(new Media(Double.parseDouble(tokens[4]),tokens[5]), Integer.parseInt(tokens[1]), tokens[2],tokens[3],Double.parseDouble(tokens[tokens.length-1]));

               break;
       }
        add(m);

    }

    //adds message into map
    private void add(Message<?> t){

        if(smartData.containsKey(t.getFrom())){
            ArrayList<Message<?>> messages = smartData.get(t.getFrom());
            messages.add(t);
        }else{
            ArrayList<Message<?>> messages = new ArrayList<>();
            messages.add(t);
            smartData.put(t.getFrom(),messages);
        }
    }

    //lists and calls toString for all elements in the given arraylist
    private void listAccount(String key, ArrayList<Message<?>> account){
        System.out.println("Account: "+key);
        double totalCharges = 0;
        for(Message<?> elem: account){
            totalCharges+=elem.getCharge();
            System.out.println(elem.toString());
        }
        System.out.printf("Total Charges: %.2f\n",totalCharges);
    }

    //calls listAccount on all the arraylist elements
    private void listAllAccounts(){
        Iterator<String> sets = smartData.keySet().iterator();
        while(sets.hasNext()){
            String account = sets.next();
            listAccount(account,smartData.get(account));
        }
    }

    //erase helper method
    private void eraseHelper(List<? extends Item> entry){
        for(Item item: entry){
            if(item instanceof Message<?>){
                Message<?> message = (Message<?>) item;
                if(message.getData() instanceof Media){
                    entry.remove(item);
                    break;
                }
            }
        }
    }

    //deletes all
    private void deleteFirstAll(){
        Iterator<String> sets = smartData.keySet().iterator();
        while(sets.hasNext()){
           eraseHelper(smartData.get(sets.next()));
        }
    }

    //prompts phone number and removes that phone number
    private void disconnectPhoneNum(Scanner s){
        System.out.println("Enter Phone Number:");
        String phoneNum = s.next();
        if(smartData.containsKey(phoneNum)){
            double totalCharges = 0;
            for(Message<?> message : smartData.get(phoneNum)){
                totalCharges+=message.getCharge();
            }
            System.out.printf("Total Charges: %.2f\n",totalCharges);
            smartData.remove(phoneNum);
        }else{
            System.out.println(phoneNum+" does not exist");
        }
    }


    //starts program
    public void run(){
        Scanner scan = new Scanner(System.in);
        int next = 0;

        do{
            switch (next){
                case 1: listAllAccounts();break;
                case 2: deleteFirstAll();break;
                case 3: disconnectPhoneNum(scan);break;
                default:
            }
            printMenu();
        }while((next=scan.nextInt())!=4);

    }

    //prints menu
    private void printMenu(){
        System.out.println("FOOTHILL WIRELESS  at Santa Clara");
        System.out.println("1. List all accounts");
        System.out.println("2. Erase the first media message");
        System.out.println("3. Disconnect an account");
        System.out.println("4. Quit");


    }

}
