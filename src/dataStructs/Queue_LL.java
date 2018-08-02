package dataStructs;


import java.util.Scanner;

public class Queue_LL{

    public static void main(String[] arg){
        // the cmd line interface to input commands into the keyboard
        Scanner scan = new Scanner(System.in);
        String act="";
        Queue_LL queue = new Queue_LL();
        printCommands();
        while(!(act=scan.nextLine().toLowerCase()).equals("quit")){//quits if you enter in quit
            if(act.equals("capital gain")){
                String message = queue.capital_gained();
                System.out.println(message);
                if(message.startsWith("Invalid"))break;
                printCommands();
                continue;
            }
            try {//checks if valid command
                String[] tokens = act.split(" ");
                if (tokens[0].equals("buy") || tokens[0].equals("sell")) {
                    int numOfShares = Integer.parseInt(tokens[1]);
                    int price = Integer.parseInt(tokens[4].replace("$",""));
                    queue.enqueue(tokens[0].toLowerCase(),numOfShares, price);
                } else {
                    System.out.println("Invalid Command");
                }
            }catch(Exception e){
                System.out.println("Invalid Command");
            }
            printCommands();
        }

    }

    public static void printCommands(){//prints out command display
        System.out.println();
        System.out.println("Commands must be written exactly as they are with x and y being your input (caps don't matter):");
        System.out.println("buy x shares at $y each");
        System.out.println("sell x shares at $y each");
        System.out.println("capital gain");
        System.out.println("quit");
        System.out.println();
        System.out.print("Your command:");
    }

    private class Item{
        private Integer costPerStock;
        private Integer quantity;




        public Item(Integer num, Integer cost){

            costPerStock=cost;
            quantity=num;
        }

        public Integer getCostPerStock() {
            return costPerStock;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer q){
            quantity=q;
        }

        @Override
        public String toString() {
            return quantity+" Shares at $"+costPerStock;
        }
    }

    private class Node<Gen> {
        private Gen item = null;
        private Node<Gen> next = null;

        public Node(Gen i) {
            item = i;
        }

        public Node(Gen i, Node<Gen> n) {
            item = i;
            next = n;
        }

        public Node<Gen> getNext() {
            return next;
        }

        public Gen getItem() {
            return item;
        }

        public void setNext(Node<Gen> next) {
            this.next = next;
        }

        public void setItem(Gen item) {
            this.item = item;
        }
    }

    private Node<Item> sentinelHead;
    private Node<Item> tail;
    private int size=0;

    private boolean validChoices=true;
    private int profits_so_far=0;

    public Queue_LL(){
        sentinelHead = new Node<Item>(null);
        tail = sentinelHead;
    }


    public void enqueue(String status, int quantity, int cost){
        /**
         * This method enqueues if status of the transactions are buy.
         * If command is sell, then capital gain is calculated.
         *
         */
        if(status.equals("buy")) {
            tail.setNext(new Node<Item>(new Item(quantity, cost)));
            tail = tail.getNext();
            size++;
        }else{
            calculate(quantity,cost);
        }
    }

    public Item dequeue(){//removes stock from queue
        if(size==0){
            return null;
        }
        Item returned = sentinelHead.getNext().getItem();
        sentinelHead.setNext(sentinelHead.getNext().getNext());
        size--;
        return returned;
    }

    public Item peek(){
        if(size==0){
            return null;
        }
        return sentinelHead.getNext().getItem();
    }

    public void calculate(int qSell, int pSell){
        /**
         * This method is called to calculate capital gain FOR EACH SELL INVOKED
         */
        Item firstInQueue=null;
        while(qSell>0 && (firstInQueue= peek())!=null){// either there still is more stocks to sell and you still have stocks
            int itQty = firstInQueue.getQuantity();//quantity of transaction in question
            int itPrce = firstInQueue.costPerStock;//price of transaction in question

            if(itQty<=qSell){
                dequeue();//remove stocks from transaction queue
                qSell = qSell-itQty;
                profits_so_far +=(pSell-itPrce)*itQty;
            }else{
                firstInQueue.setQuantity(itQty-qSell);//alter transaction in the queue
                profits_so_far +=(pSell-itPrce)*qSell;
                qSell=0;
            }
        }
        if(firstInQueue==null){
            validChoices=false;
        }

    }

    public String capital_gained(){
        // called when user asks for capital gain
        if(!validChoices){
            return "Invalid. Cannot sell more stocks than owned";
        }
        return "Profits gained: $"+profits_so_far;


    }

}
