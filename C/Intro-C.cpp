/* 
 * File:   main.cpp
 * Author: RedDragon
 *
 * Created on January 19, 2017, 3:47 PM
 */

#include <cstdlib>
#include <stdio.h>

using namespace std;
int function(int x);
void voidFunction();
int print_big(int x[], int y);

/*
 * 
 */
int main(int argc, char** argv) {
    
    printf("Hello, World! \n");
    
// c variables :
    
    // integers - whole numbers which can be both positive & negative
    // use:
    
    char character = 127; // -128 -127
    int integer = 2147483647;  // -2,147,483,648 to 2,147,483,647
    short shortData = 0;
    long longData = -123243; 
    
    /**  (long data differs based on the processor (x86 0r 64 based) 
     *  -2,147,483,648 to 2,147,483,647  (32 based)
       –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (64 based) **/
    
    float floatData = -125.123;       // real numbers with fractions
    double doubleData = 0.0000123; 
    
    /** C does not have boolean types, usually defined  by: **/
    
#define BOOL char
#define FALSE 0
#define TRUE 1
    
// unsigned data can only be positive ** double or float cannot be unsigned
    
    unsigned char unCharacter;
    unsigned int unInt;
    unsigned short unShort;
    unsigned long unLong;
    
//-------------------------------------------------------------------------

    int foo;
    int bar = 1;
    
    int a = 0, b = 1, c = 2, d = 3, e = 4;
    
    a = b - c + d * e;
    
    printf("\n %d \n", a); /* will print 1-2+3*4 = 11 */
    
//------------ write simple program that will sum up values-----------------
    
    int a1 = 3;
    float b1 = 4.5;
    double c1 = 5.25;
    float sum;
    
    /* code */
    
    sum = a1 + b1 + c1;
    
    printf("\n the sum of a1 , b1 ,c1 is %f.\n", sum);
    
    /*
     C program conversion table 
      
     a	prints any Darwin value including lists and sets
     c	prints a single character
     d	prints an integer
     e	prints a number in exponential notation
     f	prints a real number
     g	prints a real number in the same manner as the
 	e character if the exponent is greater than 8.
 	Otherwise equivalent to the f or d characters.
     o	prints the octal conversion of an integer
     s	prints out an item of type name
     u	prints an unsigned integer
     x	prints the hexadecimal conversion of an integer
     %	prints a percent sign %
     
     */
    
    /*------------------------Arrays--------------------------------*/
    // define array of 10 integers
    // c is zero based, so producing an array of 10 will start from 0-9
    
    int numbers[10];
    
    /*populate the array*/
    
    numbers[0] = 10;
    numbers[1] = 20;
    numbers[2] = 30;
    numbers[3] = 40;
    numbers[4] = 50;
    numbers[5] = 60;
    numbers[6] = 70;
    numbers[7] = 80;
    numbers[8] = 90;
    numbers[9] = 100;
    
    printf("\n The 7th number in the array is %d \n", numbers[6]);
    
//-----------------------Strings : Defining Strings -------------------------

    // Strings in C are similar to an array of characters
    
char * name = "John Smith";    // this string is a read only
char name1[] = "John Smith";   // this string can be manipulated -> auto size
char name2[11] = "John Smith"; // This predefines the size of the array

int age = 27;

  //prints out 'John Smith' is 27 years old

printf("\n %s is %d years old.\n\n", name, age);
    
    
//-------------------------_For Loops-----------------------------
int i;

for(i = 0; i < 10; i++){
    printf(" %d \n", i);
}

int array[10] = {1,2,3,4,5,6,7,8,9,10};
int sum1 = 0;
int y;

for(y = 0 ; y < 10; y++){
    sum1 += array[y];   
}

/* sum now contains a[0] + a[1] + ..a[9] */

printf("\n Sum of the array is %d \n ", sum1);

//-----------------------------------------------------------------

int n = 0;
while(n < 10){ n++; }

//while(1){} // non-zero number is always evaluated as a true

int n1 = 0;
while (1){
    n1++;
    if(n1 == 10){ break; }
}

/* a break statement halts after 10 loops , even though the while loop never
 * evaluates to false
*/

int n2 = 0;
while (n2 < 10){
    n2++;
    /*go back to the start of the while block*/
    if(n2 % 2 == 1){ continue; }
    
    printf("\n The number is %d is even. \n", n2);
    
}
//--------In C, functions have to be declared before they are used---------

        // --> look before the main method

printf("\n The value of function is %d \n", function(1));
        
    // test function
int testFunctionArray[] = { 1,11,2,22,3,33 };
    int z;
    
    for (z = 0; z < 6; z++){
        print_big(testFunctionArray, z);
    }
    return 0;

}

//--------------------Functions---------------------------

int function(int x){
    return x * 2;
}

void voidFunction(){}

int print_big(int x[], int y){
    printf("\n %d \n", x[y]);
}

