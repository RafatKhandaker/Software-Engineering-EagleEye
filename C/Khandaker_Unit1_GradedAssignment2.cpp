/* 

Rafat Khandaker ----------- ECPI University 
Date Created: 07/27/18
Unit 1 Graded Assignement 2  Version 1.0

*/

#include <stdio.h>

#define EXIT 0;  // Define exit value

// declare variables
double interest, principal, rate;  
int term, checkLoop;

// declare functions
void promptPrincipalInput();
void promptRateInput();
void promptTermInput();

double calculateInterest();

// include main entry function
int main(void) {

	while (checkLoop != -1){
		promptPrincipalInput(); if (principal == -1) { break; }
		promptRateInput();   if (rate == -1) { break; }
		promptTermInput(); if (term == -1) { break; }

		interest = calculateInterest();

		printf_s("Your total interest is: %.2lf\n", interest);

		printf_s("enter -1 to exit or 0 to continue: ");
		scanf_s("%d", &checkLoop);
	}

	return EXIT;
}

// function to prompt user for principal input & store input value into memory
void promptPrincipalInput() {
	
	puts("Enter Principal Loan as a dollar ammount ( ex: 100.00 ) or ( -1 to Exit ): ");
	try {
		scanf_s("%lf", &principal);
	}
	catch(...){ promptPrincipalInput(); }
}

// function to prompt user for rate input & store rate value into memory
void promptRateInput() {

	puts("Enter Interest Rate as a decimal ammount ( ex: 1.67 ) or (-1 to Exit): ");
	try {
		scanf_s("%lf", &rate);
	}
	catch (...) { promptRateInput(); }

}

// function to prompt user for term input & store term value into memory
void promptTermInput() {

	puts("Enter term as number of days ( ex: 367 ) or (-1 to Exit): ");
	try {
		scanf_s("%d", &term);
	}
	catch (...) { promptTermInput(); }

}

// function to calculate interest & return value of interest
double calculateInterest( ) {
	return (double)(principal * rate * (term / 365));
}