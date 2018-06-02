/***Stamped***
*Alexander Park
*alexincupertino@gmail.com
* Lab 4 - BookStore calculating Profits
*07/24/2017
 */
#include <iostream>
#include <iomanip>
#include <cctype>
#include <cstdlib>

#define PERCENTAGE_GAINED 0.2 // I used 1-0.8 in the overall summation because I know that 80 percent is lost, so 20 percent gained

using namespace std;

//prototypes
int estimatedCopies(double expectedProportion, int size); // why can't name of functions be same as names of variables?
double profit(double price, int estimatedCopies);// I thought there was a name mangling process that allows function overloading
void output(string isbn, int estimatedCopies, double profit);// so how does function call work if the variable can be confused with function name?

int main(){
    string isbn = "";
    cout<<"Enter book number:"<<endl;
    getline(cin,isbn);

    //declare variables to be processed
    int copies,expectedClass=0;
    char codeRequiredSuggested, codeBookState=' ';
    double price,totalProfit=0.0;

    //prompt user as needed for data
    cout<<"Enter price per copy:"<<endl;
    cin >> price;
    cout << "Enter expected class enrollment:"<<endl;
    cin >> expectedClass;
    cout << "Enter 'R' if required or 'S' if suggested:"<<endl;
    cin >> codeRequiredSuggested;
    codeRequiredSuggested = toupper(codeRequiredSuggested);

    //Error message if invalid data
    if(codeRequiredSuggested!='R' && codeRequiredSuggested !='S'){
        cout << "INVALID INPUT"<<endl;
        exit(EXIT_FAILURE);
    }

    cout<< "Enter 'N' if new or 'O' if not a new text:" <<endl;
    cin >> codeBookState;
    codeBookState = toupper(codeBookState);

    if(codeBookState !='N' && codeBookState!='O'){
        cout << "INVALID INPUT"<<endl;
        exit(EXIT_FAILURE);
    }

    double mprofit=0;
    int m_estimatedCopies = 0;

    //decide which proportion will be chosen
    if(codeBookState=='N'){
        if(codeRequiredSuggested=='R'){
            // if new and required
            m_estimatedCopies = estimatedCopies(0.9,expectedClass);
            mprofit = profit(price,m_estimatedCopies);

        }
        else if (codeRequiredSuggested=='S'){
            //if new and suggested
            m_estimatedCopies = estimatedCopies(0.4,expectedClass);
            mprofit = profit(price,m_estimatedCopies);
        }

    }
    else if (codeBookState=='O'){
        if(codeRequiredSuggested=='R'){
            //if old and required
            m_estimatedCopies = estimatedCopies(0.65,expectedClass);
            mprofit = profit(price,m_estimatedCopies);

        }
        else if (codeRequiredSuggested=='S'){
            //if previously suggested
            m_estimatedCopies = estimatedCopies(0.2,expectedClass);
            mprofit = profit(price,m_estimatedCopies);
        }

    }


    output(isbn,m_estimatedCopies,mprofit);

}

int estimatedCopies(double expectedProportion, int size){
    /*
     * Pre: expectedProportion - expected Proportion of students
     *      size - size of class
     * Post : estimated copy amount
     * Purpose: calculate estimated copy amounts
     */
    return static_cast<int>(size*expectedProportion +0.5);
}
double profit(double price, int estimatedCopies){
    /*
     * Pre: price - price of book
     *      estimatedCopies - estimated copies
     * Post: profit made of bookstore
     * Purpose: to calculate profit
     */
    return price*estimatedCopies*PERCENTAGE_GAINED;
}

void output(string isbn,int estimatedCopies, double profit){
    /*
     * Pre: isbn - isbn number
     *      estimatedCopies - estimated copies
     *      profit - profit to be gained
     * Post: none
     * Purpose: to output everything
     */
    cout.precision(2);
    cout << fixed;
    cout << "Alexander Park"<<endl;
    cout << "alexincupertino@gmail.com\nLab4:"<<endl;
    cout << "ISBN:"<<isbn<<endl;
    cout<<"Estimated Copies:"<<estimatedCopies<<endl;
    cout << "Profit: $"<<profit<<endl;
}
/**
 * Output:
Enter book number:
0755798652
Enter price per copy:
34.98
Enter expected class enrollment:
34
Enter 'R' if required or 'S' if suggested:
r
Enter 'N' if new or 'O' if not a new text:
o
Alexander Park
alexincupertino@gmail.com
Lab4:
ISBN:0755798652
Estimated Copies:22
Profit: $153.91


Enter book number:
2462462464
Enter price per copy:
5.95
Enter expected class enrollment:
40
Enter 'R' if required or 'S' if suggested:
s
Enter 'N' if new or 'O' if not a new text:
o
Alexander Park
alexincupertino@gmail.com
Lab4:
ISBN:2462462464
Estimated Copies:8
Profit: $9.52


Enter book number:
8953647888
Enter price per copy:
65.99
Enter expected class enrollment:
35
Enter 'R' if required or 'S' if suggested:
N
INVALID INPUT
 *
 *
 * */


