/***Stamped***
*Alexander Park 
*alexincupertino@gmail.com
* Lab 7
*08/12/2017
*/
#include <iostream>
#include <iomanip>
#include <fstream>
#include <cstdlib>

#define MAX_GYM 100 // max gymnast numbers

using namespace std;

void getData(ifstream &infile, string names[], int ages[],double scores[]);
void selectionSort(string names[], int ages[] , double scores[]);
void outputHeader(ofstream &outFile,int outputType);
void outputOne(ofstream &outFile, string names[], int ages[], double scores[]);
void outputTwo(ofstream &outFile, string names[], int ages[], double scores[]);

void getData(ifstream &infile, string names[], int ages[],double scores[]){

    /*
     * Pre: infile - reference to the input stream
     *      names - points to the array of names which are strings
     *      ages - points to the array of integer ages
     *      scores - points to the array of scores that are doubles
     * Post - none
     * Purpose - to gather all input from file and calculate the scores
     */
    int i=0;
    while(!infile.eof()){

        getline(infile,names[i]);
        infile >> ages[i];
        double tempScore=0.0;
        for(int j=0;j<4;j++){
            infile >> tempScore;
            scores[i]+=tempScore;
        }
        string temp;
        getline(infile,temp);
        i++;

    }
    infile.close();

}

void selectionSort(string names[], int ages[] , double scores[]){
    /*
    * Pre:
    *      names - points to the array of names which are strings
    *      ages - points to the array of integer ages
    *      scores - points to the array of scores that are doubles
    * Post - none
    * Purpose - to sort all arrays based on highest score
    */
    int index=0;
    bool swap=false;
    for(int i=0;i<MAX_GYM;i++){
        for(int j=0;j<MAX_GYM-i;j++){
            if(scores[j]>scores[index]) {
                swap = true;
                index = j;
            }
        }
        if(swap){
            double temp = scores[index];
            scores[index] = scores[MAX_GYM-i-1];
            scores[MAX_GYM-i-1] = temp;

            string tempString = names[index];
            names[index] = names[MAX_GYM-i-1];
            names[MAX_GYM-i-1] = tempString;

            int tempAge = ages[index];
            ages[index] = ages[MAX_GYM-i-1];
            ages[MAX_GYM-i-1] = tempAge;
        }

        index=0;
    }

}

void outputHeader(ofstream &outFile,int outputType){
    /*
    * Pre: outfile - reference to the output stream
    *      outputType - is it output one or two
    * Post - none
    * Purpose - to output the headers
    */
    outFile<<"2017 USAIGC/IAGC WORLD CHAMPIONSHIPS"<<endl;
    if(outputType==1)outFile<<setw(25)<<left<<"Name"<<setw(3)<<right<<"Age"<<setw(15)<<right<<"All Around"<<endl;
    else if (outputType==2)outFile<<setw(25)<<left<<"Name"<<setw(15)<<right<<"All Around"<<endl;
}

void outputOne(ofstream &outFile, string names[], int ages[], double scores[]) {
    /*
    * Pre: outfile - reference to the output stream
    *      names - points to the array of names which are strings
    *      ages - points to the array of integer ages
    *      scores - points to the array of scores that are doubles
     *     outputType - is it output one or two
    * Post - none
    * Purpose - to output all the content
    */
    outFile.precision(3);
    outFile<<fixed;

    for (int i = MAX_GYM; i >= 0; i--) {
        if (scores[i] == 0 || ages[i] == 0) continue;
        outFile << setw(25) << left << names[i] << setw(3) << right << ages[i] << setw(15) << right << scores[i] << endl;
    }
    outFile<<endl;
}

void outputTwo(ofstream &outFile, string names[], int ages[], double scores[]) {
    /*
    * Pre: outfile - reference to the output stream
    *      names - points to the array of names which are strings
    *      ages - points to the array of integer ages
    *      scores - points to the array of scores that are doubles
     *     outputType - is it output one or two
    * Post - none
    * Purpose - to output all the content of ten year olds
    */
    outFile.precision(3);
    outFile<<fixed;

    for (int i = MAX_GYM; i >= 0; i--) {
        if (ages[i] == 10) {
            outFile << setw(25) << left << names[i] << setw(15) << right << scores[i] << endl;
        }
    }

    outFile<<endl;
}




int main() {
    double scores[100];
    int ages[100];
    string names[100];
    for(int i=0;i<100;i++){//initialize all the array values
        scores[i]=0.0;
        ages[i]=0;
        names[i]="";
    }

    ifstream is;
    is.open("gym.txt");//open text file
    if(is.fail()){
        cout <<"FAILED";
        exit(1);
    }
    ofstream os;
    os.open("output.txt");
    getData(is,names,ages,scores);
    selectionSort(names,ages,scores);
    os<<"Alexander Park\n"<<"Lab 7\n"<<"alexincupertino@gmail.com\n"<<endl;
    outputHeader(os,1);
    outputOne(os,names,ages,scores);
    outputHeader(os,2);
    outputTwo(os,names,ages,scores);
    os.close();
    return 0;
}


