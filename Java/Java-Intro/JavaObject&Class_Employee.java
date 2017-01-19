package day2.ClassAndObjects;

public class Employee {
	
	double salary;
	double bonus;
// void does not save value it only being used to print totalPay	
 void calculateTotalPay(){
		double totalPay = salary + bonus;
		System.out.println("Total Pay = " + totalPay);
	}

	}


