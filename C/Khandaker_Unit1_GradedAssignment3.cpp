/* --- Unit 1 Graded Assignment 3   --- 
	By: Rafat Khandaker  ECPI University  Version 1.0
	Created: 07/28/18
*/
#include <stdio.h>

// define exit value	
#define EXIT 0

// Begin Main Function 
int main() {
	
	int grade = 76;
	
	if (grade >= 60 && grade <= 100) {
		printf("Passed\n"); 
	}
	else if (grade < 60 && grade >= 0) {
		printf("Failed\n");
	}
	else {
		printf("Invalid Input\n");
	}

	printf("enter any value to exit...");
	scanf("%d");  // placeholder to pause program
	return EXIT;
}

