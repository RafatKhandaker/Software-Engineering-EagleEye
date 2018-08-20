/*______________________________________________________________
  ECPI University
  CIS 126, Dr. Malone

  By: Rafat Khandaker
  Created: 08/05/18     
  ______________________________________________________________
*/

#include <stdio.h>  // imports

#define Exit 0;  // define exit variable

/*Main Entry Function*/
int main(void) 
{
	/*Variable declaration*/
	int number;
	int sum = 0;

	printf_s("\n\nEnter the number of values to be processed: ");  // prompt user
	scanf_s("%d", &number);   // read input for number of loops

	/* looping structure */
	for (int i = 1; i <= number; i++) 
	{
		int value;  // initialize input variable inside looping scope block

		printf_s("\n\nEnter a value: ");  // prompt user to input value
		scanf_s("%d", &value);  // read input for value

		sum += value;  // add to the total sum (sum = sum + value')
	}

	printf("\n\nSum of the %d values is %d", number, sum);   // print final output of result

	printf_s("\n\nPress any key to continue . . . ");  // prompt exit message
	scanf_s("%d", &sum);   // place holder for program to exit

	return Exit;   // exit main
}	

