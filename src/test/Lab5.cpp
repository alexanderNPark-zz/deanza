/***Stamped***
 * Alexander Park
 * 7/30/17
 * Lab5 - mortage loans
 */
#include <iostream>
#include <iomanip>

#define COST_UTILITIES 300.00
#define TAX_RATE 0.0125
#define INSURANCE 550.00

using namespace std;

void input(double &sellingPrice, double &rateOfInterest,int &numberOfYears);//why don't we use pointers? *sellingPrice, cin >> *sellingPrice, I know in C we use pointers
void calculateAll(double sellingPrice,double rateOfInterest, double &downPayment,double downRate,
                  double &amountLoan,double &mortagePayment, int numberYears,double &propertyTax, double &total);
void calculateLoan(double sellingPrice,double rateOfInterest,
                   double &downPayment,double downRate,
                   double &amountLoan,double &mortagePayment, int numberYears);
void output(double sellingPrice,double rateOfInterest,
            double downPayment,double downRate,
            double amountLoan,double mortagePayment,
            int numberYears,double propertyTax, double total);

int main(){
    double const downPaymentRate=0.2;
    double sellingPrice,rateOfInterest,downPayment,amountLoan,mortagePayment,propertyTax,total =0.0;
    int numberOfYears = 0;

    input(sellingPrice,rateOfInterest,numberOfYears);
    calculateAll(sellingPrice,rateOfInterest, downPayment,downPaymentRate,amountLoan,mortagePayment, numberOfYears,propertyTax,total);
    output(sellingPrice,rateOfInterest,
                downPayment,downPaymentRate,
                amountLoan,mortagePayment,
                numberOfYears,propertyTax,total);

}

void calculateLoan(double sellingPrice,double rateOfInterest,
                   double &downPayment,double downRate,
                   double &amountLoan,double &mortagePayment, int numberYears){
    /*
    * Pre: sellingPrice-selling price of house,rateOfInterest - annual interest rate ,
           downPayment-down payment on house,downRate-percentage down payment,
           amountLoan-amount loaned,mortagePayment- monthly mortage payment,
           numberYears-term of loan duration
      Post: none
      Purpose: to calculate mortage, down payment, amount loaned
    */
    downPayment = downRate*sellingPrice;
    amountLoan = sellingPrice-downPayment;
    double compoundedYearsInterest = 1;
    for(int i=0; i<numberYears*12;i++) compoundedYearsInterest*=(1+rateOfInterest/12);
    mortagePayment = amountLoan*(rateOfInterest/12)*compoundedYearsInterest/(compoundedYearsInterest-1);

}

void calculateAll(double sellingPrice,double rateOfInterest,
                    double &downPayment,double downRate,
                    double &amountLoan,double &mortagePayment, int numberYears,double &propertyTax, double &total){
    /*
    * Pre: sellingPrice-selling price of house,rateOfInterest - annual interest rate ,
           downPayment-down payment on house,downRate-percentage down payment,
           amountLoan-amount loaned,mortagePayment- monthly mortage payment,
           numberYears-term of loan duration,propertyTax-property tax on house,
           total-total amount
      Post: none
      Purpose: to calculate everything
    */

    propertyTax = sellingPrice*TAX_RATE/12;
    calculateLoan(sellingPrice,rateOfInterest,downPayment,downRate,amountLoan,mortagePayment,numberYears);
    total = mortagePayment+COST_UTILITIES+INSURANCE+propertyTax;
}

void input(double &sellingPrice, double &rateOfInterest,int &numberOfYears){
    /*
     * Pre: sellingPrice-selling Price of house
     *      rateOfInterest - annual interest rate
     *      numberOfYears - annual interest rate
     * Post: none
     * Purpose: to gather input
     */
    cout << "Selling Price? "<<endl;
    cin >> sellingPrice;
    cout << "Interest Rate? (EX:10% -> put 0.1)"<<endl;
    cin >> rateOfInterest;
    cout<<"Number of Years? "<<endl;
    cin >> numberOfYears;
}

void signature(){
    cout << "Alexander Park"<<endl;
    cout <<"alexincupertino@gmail.com"<<endl;
    cout << "Lab 4"<<endl;
    cout<<endl;
}

void output(double sellingPrice,double rateOfInterest,
            double downPayment,double downRate,
            double amountLoan,double mortagePayment,
            int numberYears,double propertyTax,double total){
    /*
     * Pre: sellingPrice-selling price of house,rateOfInterest - annual interest rate ,
            downPayment-down payment on house,downRate-percentage down payment,
            amountLoan-amount loaned,mortagePayment- monthly mortage payment,
            numberYears-term of loan duration,propertyTax-property tax on house,
            total-total amount
       Post: none
       Purpose: to output everything
     */
    signature();
    cout.precision(2);
    cout << fixed;
    cout << "MONTHLY COST OF HOUSE"<<endl;
    cout<<endl;
    cout<<setw(35)<<left<<"SELLING PRICE"<<setw(10)<<right<<"$"<<setw(10)<<right<< sellingPrice<<endl;
    cout<<setw(35)<<left<<"DOWN PAYMENT"<<setw(20)<<right<< downPayment<<endl;
    cout<<setw(35)<<left<<"AMOUNT LOANED"<<setw(20)<<right<< amountLoan<<endl;
    cout.precision(1);
    cout << fixed;
    cout<<setw(35)<<left<<"INTEREST RATE"<<setw(19)<<right<< (rateOfInterest*100)<<"%"<<endl;
    cout<<setw(35)<<left<<"TAX RATE"<<setw(19)<<right<< (TAX_RATE*100)<<"%"<<endl;
    cout.precision(0);
    cout <<fixed;
    cout<<setw(35)<<left<<"DURATION OF LOAN"<<setw(20)<<right<< numberYears<<endl;
    cout.precision(2);
    cout<<fixed;
    cout<<"MONTHLY PAYMENT"<<endl;
    cout<<setw(5)<<""<<setw(20)<<left<<"MORTAGE"<<setw(30)<<right<<mortagePayment<<endl;
    cout<<setw(5)<<""<<setw(20)<<left<<"UTILITIES"<<setw(30)<<right<<COST_UTILITIES<<endl;
    cout<<setw(5)<<""<<setw(20)<<left<<"PROPERTY TAXES"<<setw(30)<<right<<propertyTax<<endl;
    cout<<setw(5)<<""<<setw(20)<<left<<"INSURANCE"<<setw(30)<<right<<INSURANCE<<endl;
    cout<<setw(55)<<right<<"__________"<<endl;
    cout<<setw(45)<<right<<"$"<<setw(10)<<right<<total<<endl;

}

/*
 * Output
Selling Price?
600000
Interest Rate? (EX:10% -> put 0.1)
0.05
Number of Years?
20
Alexander Park
alexincupertino@gmail.com
Lab 4

MONTHLY COST OF HOUSE

SELLING PRICE                               $ 600000.00
DOWN PAYMENT                                  120000.00
AMOUNT LOANED                                 480000.00
INTEREST RATE                                      5.0%
TAX RATE                                           1.3%
DURATION OF LOAN                                     20
MONTHLY PAYMENT
     MORTAGE                                    3167.79
     UTILITIES                                   300.00
     PROPERTY TAXES                              625.00
     INSURANCE                                   550.00
                                             __________
                                            $   4642.79
 */
