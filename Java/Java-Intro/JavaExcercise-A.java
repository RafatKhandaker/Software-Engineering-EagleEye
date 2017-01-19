// In this exercise, the tax will be calculated for salary ranges
// if salary is up to 15000 then tax will be 10%
// if salary is up to 40000 then tax will be 20%
// if salary is more than 40000 then tax will be 30%
public class ExcerciseA {

	public static void main(String[] args) {
		
		double salary = 78678.65;
		double tax = 0.0; 
		
		if(salary <= 15000){ 
			tax = salary * .10;
		}else if(salary <= 40000){
			tax = salary * .20;
		}else{
			tax = salary * .30;
		}
		
		System.out.println("Tax = " + tax);

	}

}
