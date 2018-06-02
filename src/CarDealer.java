// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  CarDealer.java

//  Program purpose: This program is to process car vehicle data and search with cmd line interaction.

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   04/22/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------

import java.util.Scanner;



public class CarDealer {

    //private instance variables
    private Vehicle[] totalCars;
    private int number_of_cars;
    private String location;

    private static String dealership_brand = "Foothill Dealership";
    private static int max_num_cars = 1024;

    //Private accessors
    public static int max_number_cars(){
        return max_num_cars;
    }

    public static String dealership(){
        return dealership_brand;
    }

    public String getLocation(){
        return location;
    }

    public int getNumber_of_cars() {
        return number_of_cars;
    }

    //default constructor
    public CarDealer(){
        location = "";
        number_of_cars = 0;
        totalCars = new Vehicle[max_num_cars];

    }

    //non-default constructor
    public CarDealer(String location){
        this.location = location;
        number_of_cars = 0;
        totalCars = new Vehicle[max_num_cars];

    }

    public void init(){

        System.out.println("Welcome to "+dealership_brand+" at "+location+"... Loading vehicles from DB ... Please wait ...");
        Scanner scan = new Scanner(System.in);
        boolean not_done = true; //indicates when 'END;' is the data

        while(not_done){
            not_done = false;
            //prompt user for information
            System.out.print("Enter Make;Model;Year;Price [Ford;Taurus;2014;14578.99] or [END;] to quit:");
            String data = scan.nextLine();

            if(!data.equals("END;")){
                //tokenize the data if it is not "END;"
                String[] tokens = data.split(";");
                int year = Integer.parseInt(tokens[2]);//get the year the
                double price = Double.parseDouble(tokens[3]); // get the price in decimal
                totalCars[number_of_cars] = new Vehicle().setMake(tokens[0]).setModel(tokens[1]).setYear(year).setPrice(price);
                //use mutator methods
                number_of_cars+=1; // increment the array pointer one more
                not_done = true;
            }

        }
        System.out.println(); // DO NOT CLOSE SCAN AS CLOSING SCAN WILL CLOSE inputstream System.in
    }

    //automatic prompt of menu
    public void menu(){
        System.out.println("\tSMART SEARCH");
        System.out.println("1.View Vehicle Inventory");
        System.out.println("2.Search by make and model");
        System.out.println("3.Smart search based on year and price");
        System.out.println("4.Quit");
        System.out.println("5.Reserve Vehicle");
        System.out.println("6.View Reserved Inventory");


    }

    //message if user chooses to quit
    public void quit(){
        System.out.println("Thanks for using "+dealership_brand+" at "+location+".");
    }


    //performs search of model based on vehicle make and model
    public void searchMakeModel(){

        Scanner scan = new Scanner(System.in);
        //prompt user for information
        System.out.print("\t\tEnter vehicle make: ");
        String target_make = scan.nextLine();

        System.out.print("\t\tEnter vehicle model: ");
        String target_model = scan.nextLine();

        for (int i =0; i<number_of_cars;i++){
            Vehicle v = totalCars[i];
            //match make and model together
            if(!v.isReserved() && v.getMake().equals(target_make) && v.getModel().equals(target_model) ){
                System.out.println(v);
            }
        }

    }

    //will resserve vehicle based on exact description of the car
    public void reserveVehicle(){
        //prompt user for information
        Scanner scan = new Scanner(System.in);
        System.out.print("\t\tEnter vehicle make: ");
        String target_make = scan.nextLine();

        System.out.print("\t\tEnter vehicle model: ");
        String target_model = scan.nextLine();

        System.out.print("\t\tEnter vehicle year: ");
        int target_year = scan.nextInt();

        System.out.print("\t\tEnter vehicle price: ");
        double target_price = scan.nextDouble();


        boolean found = false; //message state at the end if the user got something wrong

        for (int i =0; i<number_of_cars;i++){
            Vehicle v = totalCars[i];
            if(!v.isReserved() && v.getMake().equals(target_make) && v.getModel().equals(target_model)
                    && v.getYear() == target_year && v.getPrice() == target_price){ //check precise equality
                found = true;
                v.setReserved(true);
                break;// END right here because we have found this person's particular vehicle
            }
        }

        if(found){
            System.out.println("Vehicle Reserved Now.");
        }
        else{
            System.out.println("No Vehicle Could Be Found With That Description.");
        }

    }

    //prints out all reserved cars in the Vehicle Inventory
    public void reservedInventory(){
        System.out.println();
        System.out.println("Reserved Inventory:");
        System.out.println();
        for (int i =0; i<number_of_cars;i++){
            Vehicle v = totalCars[i];
            if(v.isReserved()){
                System.out.println(v+"\n");
            }
        }
    }

    //prints out the whole inventory of the Vehicles of the CarDealer
    public void viewInventory(){
        System.out.println();
        System.out.println("\t-------------------------------------");

        System.out.println("\t|           VEHICLE INVENTORY       |");

        System.out.println("\t-------------------------------------");

        System.out.println("MAKE & MODEL                  YEAR      PRICE");

        System.out.println("---------------------------------------------");
        System.out.println();

        for (int i =0; i<number_of_cars;i++){
            Vehicle v = totalCars[i];
            System.out.println(v+"\n");
        }

    }

    //performs a search asking for the minimum year and max year and min price and max price and finding Vehicles
    //that are within those ranges
    public void smartSearch(){
        Scanner scan = new Scanner(System.in);
        //prompt user for information
        System.out.print("\t\tEnter vehicle minimum price: ");
        double min_price = scan.nextDouble();

        System.out.print("\t\tEnter vehicle maximum price: ");
        double max_price = scan.nextDouble();

        System.out.print("\t\tEnter vehicle minimum year: ");
        int min_year = scan.nextInt();

        System.out.print("\t\tEnter vehicle maximum year: ");
        int max_year = scan.nextInt();

        for (int i =0; i<number_of_cars;i++){
            Vehicle v = totalCars[i];
            if(!v.isReserved() && v.getYear()>min_year && v.getYear()<=max_year && v.getPrice()>min_price && v.getPrice()<=max_price){
                System.out.println(v);
            }
        }


    }

    //runs the second half of the CarDealer program
    //provides user interface with the main choice selection
    public void run(){
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        while(running){
            menu();//display menu
            System.out.print("\t\tEnter your choice: ");
            int choice = scan.nextInt();//take choice from user
            switch (choice){
                case 1:viewInventory();break;
                case 2:searchMakeModel();break;
                case 3:smartSearch();break;
                case 4:quit();running = false;break;
                case 5:reserveVehicle();break;
                case 6:reservedInventory();
            }
            System.out.println();
        }
        scan.close(); //end the program with a close
    }


}
