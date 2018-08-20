/*____________________________________________________________________

	ECPI University
	CIS 126, Dr. Malone
	By: Rafat Khandaker
	Created: 08/11/18 16:45
________________________________________________________________________
*/


/* include Libraries */
#include <stdio.h>   

/* include main function*/
int main() 
{
	/*initialize variables*/
	int i, n, sum = 0;
	int num[10];
	float average;


	do {
		printf("Enter the number of values to be averaged (10 or less): ");  // prompt user to enter number of values
		scanf("%d", &n);  // store number of values
	} while (n > 10);  // validation to make sure n is less than array size

	for (i = 0; i < n; i++) 
	{
		printf("\n\nEnter a number: "); // prompt to enter number in array
		scanf("%d", &num[i]);  // store value to array
		sum += num[i];  // add value to sum
	}

	average = (float)(sum / n);  // calculate average and cast output as float
	printf("\n\nThe Average of sequence is: %.2f", average);  // print output of average

	printf("\n\n\nPress any key to continue . . .");  // prompt exit message
	scanf("%d", &n);  // store variable & exit program

	return 0; // Exit program with 0
}