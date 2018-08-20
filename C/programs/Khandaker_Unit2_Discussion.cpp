#include <stdio.h>

int add(int x, int y); // function prototype
int factorial(int a);

int exit;

int main() 
{
	int a, b;
	int sum; // declares the variables used in the program
	int fac;

	printf("Enter the first number: ");
	scanf("%d", &a);

	printf("Enter the second number: ");
	scanf("%d", &b);

	sum = add(a, b); // function call
	printf("The sum of the two numbers is : %d \n", sum); // displays the sum after executing add function

	printf("The value stored in the variable sum is : %d \n", sum); // displays the value stored in the variable sum

	fac = factorial(a);
	printf("factorial of %d is: %d ", a, fac);

	scanf("%d", exit);

	return 0;
}

int add(int x, int y) //function definition
{
	return x + y;
}

int factorial(int a) {
	return (a == 1)? 1 : a* factorial(a-1);
}