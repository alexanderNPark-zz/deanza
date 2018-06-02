/***Stamped***
 * Alexander Park
 * 7/30/17
 * Lab6 - Credit Debt
 */
#include <iostream>
#include <iomanip>
#include <fstream>
#include <cstdlib>

#define MIN_PAYMENT 15.00
using namespace std;

void input(double &creditBal, double &inRate, double &minPayRate);
void header(ostream &outfile, double creditBal, double inRate, double minPayRate);
void calculate(double &creditBal, double inRate, double minPayRate, double &sumOfInterestPaid, double &interestPaid, double &minPayments);
void outputPerLine(ostream &outFile,int month, double creditBal,double sumOfInterestPaid, double interestPaid, double minPayments);



int main(){
    // declare all variables here
    double creditBalance,interestRate,percentMinimumPayment,
            interestPaid, miniPayments, sumOfInterestPaid = 0.0;

    input(creditBalance,interestRate,percentMinimumPayment);//get all input data
    ofstream os;
    os.open("output.txt");// So, ofstream creates a file if it does not exist?
    header(os,creditBalance,interestRate,percentMinimumPayment);
    int i=1;
    while(creditBalance>0.0049){//stop when it is is no longer roundable to 0.01 which is therefore 0
        calculate(creditBalance,interestRate,percentMinimumPayment,sumOfInterestPaid,interestPaid,miniPayments);
        outputPerLine(os,i,creditBalance,sumOfInterestPaid,interestPaid,miniPayments);
        i++;//increment month afterward
    }
    os << "Press Any Key to Continue..."<<endl; // Do I really need this?
    os.close();//remember to close the output stream object
    return 0;
}

void input(double &creditBal, double &inRate, double &minPayRate){
    /*
    * Pre: creditBal - reference to credit balance
     *     inRate - reference to interest rate
     *     minPayRate - reference to minimum pay rate
    * Post: none
    * Purpose: to get all inputs
    *
    */
    ifstream in;
    in.open("lab6.txt");
    if (in.fail()){//CHECK existance
        cout << "No such file";
        exit(1);
    }
    in >> creditBal;
    in >> inRate;
    in >> minPayRate;
    in.close();// remember to close the input stream object
}

void calculate(double &creditBal, double inRate, double minPayRate, double &sumOfInterestPaid, double &interestPaid, double &minPayments){
    /*
    * Pre: creditBal - reference to credit balance
     *     inRate - interest rate
     *     minPayRate - minimum pay rate
    *      sumOfInterestPaid - (isn't the name quite self explanatory) reference to sum of the interest paid over years
    *      interestPaid - reference to interest paid this month
    *      minPayments - reference to minimum payments
    * Post: none
    * Purpose: to calculate every thing
    *
    */
    interestPaid = creditBal*(inRate/100)/12;
    minPayments = (creditBal+interestPaid)*minPayRate/100;
    if(minPayments<=MIN_PAYMENT && creditBal>=MIN_PAYMENT){
        minPayments=MIN_PAYMENT;
    }
    else if(minPayments<MIN_PAYMENT) minPayments=creditBal+interestPaid;
    creditBal = creditBal+interestPaid - minPayments;
    if(creditBal<0.005) creditBal=0.000; // meaningful up to 2 digits after decimal rounding
    sumOfInterestPaid+=interestPaid;
}

void header(ostream &outfile, double creditBal, double inRate, double minPayRate) {
    /*
     * Pre: outfile - reference to output stream object
     *      creditBal - credit balance
     *      inRate - interest rate
     *      minPayRate - minimum pay rate
     * Post: none
     * Purpose: to put the header into the file
     *
     */

    outfile << "Alexander Park"<<endl;//signature
    outfile<<"alexincupertino@gmail.com"<<endl;
    outfile<< "Lab 6"<<endl;

    outfile << "Balance Owing: $\t" << creditBal << endl;
    outfile << "APR as %\t" << inRate << endl;
    outfile << "Percent for minimum payment as %\t" << minPayRate << endl;
    outfile << setw(5) << left << "Month" << setw(10) << right << "Balance" << setw(15) << right << "Interest"
            << setw(15) << right << "Minimum" << setw(15) << right << "Sum of" << endl;
    outfile << setw(32) << "this month" << setw(34) << right << "interest paid" << endl;
    outfile.precision(2);
    outfile<<fixed;

}

void outputPerLine(ostream &outFile, int month, double creditBal,double sumOfInterestPaid, double interestPaid, double minPayments){
    /*
     * Pre: outFile - reference to output stream object
     *      month - month number
     *      creditBal - credit balance
     *      sumOfInterestPaid - (isn't the name quite self explanatory) sum of the interest paid over years
     *      interestPaid - interest paid this month
     *      minPayments - minimum payments
     * Post: none
     * Purpose: to output one line at a time into the file
     *
     */
    outFile << setw(5) << right << month << setw(10) << right << creditBal<< setw(17) << right << interestPaid
            << setw(13) << right << minPayments << setw(15) << right << sumOfInterestPaid << endl;
}

