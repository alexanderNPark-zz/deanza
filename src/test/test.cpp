/***Stamped***
*Alexander Park 
*alexincupertino@gmail.com
*08/12/2017
*/
#include <iostream>
#include <iomanip>
#include <fstream>

#define WATER_WEIGHT 62.42796

using namespace std;

void readAndPrint(ifstream &infile){
    cout <<setw(15)<<left << "Efficiency" <<setw(15) <<right<<"Money"<<endl;
    int numofPeople=0;

    double miles, gallons, money, effic=0.0;

    while(!infile.eof()){

        infile >> numofPeople >> miles >> gallons;
        effic = numofPeople*miles/gallons;
        if(effic > 25.0){
            money = miles*0.08;
            cout << setw(10) << left<<setprecision(1)<<fixed<<effic<< setw(19)<<right<<setprecision(2)<<fixed << "$"<<setw(5)<<right<<money<<endl;
        }
    }
    infile.close();

}


int main() {
    ifstream is;
    is.open("car.txt");
    readAndPrint(is);

    return 0;
}


