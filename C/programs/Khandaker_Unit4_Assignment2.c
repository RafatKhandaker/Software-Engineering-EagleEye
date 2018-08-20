/*Include Libraries*/
#include <stdio.h>
#include <ctype.h>

/*initialize main function*/
int main(void)
{
	char c; // initialize char c
	int exit; // exit variable for placeholder

	printf("Enter a character: "); // prompt use to enter character

	scanf("%c", &c); // store character input

	if (isdigit(c) == 0)  // validate if c is digit equal to false
	{
		printf("\nUser has entered the character: %c", c); // display output of c if 0
	}
	if (isblank(c) == 0)  // validate if c is isblank equal to false
	{
		printf("\n\nisblank('%c') = %d", c, isblank(c)); // display output of c if blank
	}
	if (islower(c) == 0)  // validate if c is lower case equal to false
	{
		printf("\n\nislower('%c') = %d", c, islower(c)); // display output of c if lowercase
	}
	if (iscntrl(c) == 0)  // validate if c is control char equal to false
	{
		printf("\n\niscntrl('%c') = %d", c, iscntrl(c)); // display output of c if control char
	}
	if (isspace(c) == 0)  // validate if c is space char equal to false
	{
		printf("\n\nisspace('%c') = %d", c, isspace(c)); // display output of c if control char
	}

	scanf("%d", &exit);
	return 0; // exit with 0
}