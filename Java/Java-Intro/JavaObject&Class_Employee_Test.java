package day2.ClassAndObjects;

public class TestEmployee {

	public static void main(String[] args) {
		
		Employee alex, linda, john;
		
			alex = new Employee();
			linda = new Employee();
			john = new Employee();
		
		alex.salary = 90000;
		alex.bonus = 20000;
		alex.calculateTotalPay();
	
		linda.salary = 100000.78;
		linda.bonus = 23456.89;
		linda.calculateTotalPay();
	
		john.salary = 36000.50;
		john.bonus = 15365;
		john.calculateTotalPay();
	

	}

}
