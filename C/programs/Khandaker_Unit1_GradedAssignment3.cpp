/* --- Unit 1 Graded Assignment 3   --- 
	By: Rafat Khandaker  ECPI University  Version 1.0
	Created: 07/28/18
*/
#include <stdio.h>

// define exit value	
#define EXIT 0

// Initialize variable
double grade;
int exit;

// Begin Main Function 
int main() {
	
// loop will make sure to run atleast once & check to see if input is valid. Will exit succesfully when the condition is met.
	do {
		printf_s("Enter a student grade between 0 and 100: ");
		scanf_s("%lf", &grade);
		puts("");

		if (grade >= 60 && grade <= 100) { 
			puts("Passed!"); 
			break; 
		}
		else if (grade < 60 && grade >= 0) { 
			puts("Failed!");
			break;
		}
		else {
			puts("Invalid Input");
		}

	} while ( !(0 <= grade && grade <= 100) );
	
	
	printf("enter 0 to exit...");
	scanf_s("%d", &exit);  // placeholder to pause program

	return EXIT;
}

