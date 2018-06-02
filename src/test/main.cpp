/**Stamped**
 Alexander Park
 Lab2 Monthly Business Sales Tax -> demonstrate our ability to format numbers and strings
 7/11/17
 */
#include <iostream>
#include <iomanip>
#include <string>

#define STATE_SALES_TAX_RATE 0.056

using namespace std;

int main() {

    // declared all variables neccessary
    const double countySalesTaxRate = 0.033;
    string monthYear = "";
    double totalCollected,totalSales,countySalesTax,stateSalesTax,totalSalesTax=0.0;

    //Prompt User for both the total collected and the month/year
    cout<<"Please give year and Month:";
    getline(cin,monthYear);
    cout<<"Please enter total collected:";
    cin >>totalCollected;

    //performed logic based on formula
    totalSales = totalCollected/(1+countySalesTaxRate+STATE_SALES_TAX_RATE);
    countySalesTax = countySalesTaxRate*totalSales;
    stateSalesTax = STATE_SALES_TAX_RATE*totalSales;
    totalSalesTax = countySalesTax+stateSalesTax;//sum of both taxes

    cout.precision(2);//set precision of float to 2 decimal points
    cout<<fixed; // set the flag into the cout operator

    cout << "Alexander Park"<<endl;

    /*printing like a table, so I need to have a fixed size for both columns*/
    int tabLength = 25;// "Country Sales tax" seems long so I chose a length around 20-30 for noticeable difference
    int minNumSize = 9;// I think the max is 8 including the decimal point, but for an extra digit in case I put 9

    cout <<setw(tabLength)<<left<<"Month:"+monthYear<<endl;// this is the only one that seems out of place because January 2017 and the month are larger
    cout <<setw(tabLength)<<left<<"Total Collected:"<<setw(minNumSize)<<right <<totalCollected<<endl;
    cout <<setw(tabLength)<<left<<"Sales:"<<setw(minNumSize)<<right <<totalSales<<endl;
    cout <<setw(tabLength)<<left<<"County Sales Tax:"<<setw(minNumSize)<<right <<countySalesTax<<endl;
    cout <<setw(tabLength)<<left<<"State Sales Tax:"<<setw(minNumSize)<<right <<stateSalesTax<<endl;
    cout <<setw(tabLength)<<left<<"Total Sales Tax:"<<setw(minNumSize)<<right <<totalSalesTax<<endl;

    return 0;

}
/*
Please give year and Month:January 2017
Please enter total collected:81673.67
Alexander Park
Month:January 2017
Total Collected:          81673.67
Sales:                    74998.78
County Sales Tax:          2474.96
State Sales Tax:           4199.93
Total Sales Tax:           6674.89
 */