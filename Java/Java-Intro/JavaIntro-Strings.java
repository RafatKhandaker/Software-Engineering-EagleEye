public class Example_Strings {

	public static void main(String[] args) {
		
// stringvalues hold text value. 0 to ...
		String x = "James Dean";
		
		System.out.println("Hello" + x);
		
		// print string value to  upper case
		System.out.println(x.toUpperCase());
		
		// print everything from the second character
		System.out.println(x.substring(2));
		
	// print everything from second character and up to 7th (not include 7th)
		System.out.println(x.substring(2,7));
		
	// print out 3rd character 
		System.out.println(x.charAt(3));
		
		
		String age = "37";
		String salary = "78965.83";
		//Wrapper Classes
		
		// convert string to integer and do operation
		int a = Integer.parseInt(age) + 2;
		System.out.println(a);
		
		// convert string to Double and do operation
		double s = Double.parseDouble(salary) * .15;
		System.out.println(s);
		
		// JAVA DATA TYPES:
		
		// byte   | 8 bits  | -128 to 127
		// short  | 16 bits | -32.768 to 32.767 
		// int    | 32 bits | -2,147,483,648 to 2,147,483,647
		// long   | 64 bits | -9,223,372,036,854,775,808 to
	                        // 9,223,372,036,854,772,807  
		// float  | 32 bits | 1.4e-045 to 3.4e+038
		// double | 64 bits | 4.9e-324 to 1.8e+308
		// char   | 16 bits | 'y'
		// bolean | 1 bit   | true or false
		// string | not a primitive data type, used to store text.
		
		

	}

}
