/**Stamped**
 Alexander Park
 Lab3 Sales VCR
 7/11/17
 */
#include <iostream>
#include <iomanip>

#define TAX_RATE 0.056 // what was this supposed to be? I didn't see a specification for what was tax.


using namespace std;


//prompt user for quantity of product
int prompt(string product){
    int qty=0;
    cout<<"How many "<<product<<" were sold? ";
    cin >>qty;
    return qty;
}

// print catalog by inputting each item,product,price,and totalPrice purchased of that item
void printCat(int qty, string product, double price, double totalPrice){
    cout<<setw(4)<<left<<qty<<setw(20)<<left<<product<<setw(8)<<right<<price<<setw(20)<<right<<totalPrice<<endl;
}
//print the end receipt of the last part, accepts the tab title and its value
void printEnd(string tab,double var){
    cout<<setw(27)<<right<<tab<<setw(15)<<right<<var<<endl;
}

int main() {
    //print out information
    cout<<"Alexander Park"<<endl;
    cout<<"alexincupertino@gmail.com"<<endl;
    cout<<"Lab 3: VCR CATALOG AND RECEIPT"<<endl;
    cout<< endl;

    //set precision early
    cout.precision(2);
    cout<<fixed;

    // initialized constants
    const double tvPrice=500.00,
            dvdPlayerPrice=380.00,
            remoteControllerPrice=35.20,
            cdPlayerPrice=74.50,
            audioVisualProcessorPrice=1500.00;

    // call 'prompt' for each product
    int qtyTv= prompt("TVs"),
            qtyDvdPlayer=prompt("DVD Players"),
            qtyRemote=prompt("Remote Controllers"),
            qtyCdPlayer=prompt("CD Players"),
            qtyAudioVis=prompt("Audio Visual Processors");

    // start calculating all total prices for each product except for the totalPrice, tax, and totalPriceWithTax
    double totalPrice=0.00,totalTax=0.0,totalPriceWithTax=0.0,
            totalPriceTv = qtyTv*tvPrice,
            totalPriceDVDPlayer=qtyDvdPlayer*dvdPlayerPrice,
            totalPriceRmote=qtyRemote*remoteControllerPrice,
            totalPriceCdPlayer=qtyCdPlayer*cdPlayerPrice,
            totalPriceAudio=qtyAudioVis*audioVisualProcessorPrice;

    //calculate the remaining variables
    totalPrice = totalPriceAudio+totalPriceCdPlayer+totalPriceDVDPlayer+totalPriceRmote+totalPriceTv;
    totalTax = totalPrice*TAX_RATE;
    totalPriceWithTax = totalPrice+totalTax;

    //print the title/first header
    cout<<setw(4)<<left<<"QTY"<<setw(20)<<left<<"Description"<<setw(20)<<left<<"Unit Price"<<setw(16)<<left<<"Total Price"<<endl;

    //print each line in the catalog
    printCat(qtyTv,"TV",tvPrice,totalPriceTv);
    printCat(qtyDvdPlayer,"DVD Player",dvdPlayerPrice,totalPriceDVDPlayer);
    printCat(qtyRemote,"Remote Controller",remoteControllerPrice,totalPriceRmote);
    printCat(qtyCdPlayer,"CD Player",cdPlayerPrice,totalPriceCdPlayer);
    printCat(qtyAudioVis,"AV Processor",audioVisualProcessorPrice,totalPriceAudio);

    //print each of the ending statements by calling print end
    printEnd("Subtotal",totalPrice);
    printEnd("Tax",totalTax);
    printEnd("Total",totalPriceWithTax);

}


/*
Alexander Park
alexincupertino@gmail.com
Lab 3: VCR CATALOG AND RECEIPT

How many TVs were sold? 13
How many DVD Players were sold? 2
How many Remote Controllers were sold? 0
How many CD Players were sold? 1
How many Audio Visual Processors were sold? 21
QTY Description         Unit Price          Total Price
13  TV                    500.00             6500.00
2   DVD Player            380.00              760.00
0   Remote Controller      35.20                0.00
1   CD Player              74.50               74.50
21  AV Processor         1500.00            31500.00
                   Subtotal       38834.50
                        Tax        2174.73
                      Total       41009.23
 */