public class Example_Arrays {


	public static void main(String[] args) {
	
		/*int a = 10;
		int b = 20;
		int c, d, e;
		c = 30;
		d = 40; e = 50; */
		
		/*int a1 = 10;
		int a2 = 20; */
		
// Arrays are used to assign a variable with multiple values. 
// Arrays start with a(0) + a(1) + a(2) + a(3) + a(4)...
		int[] a = {10, 20, 30, 40, 50}; 
	       // choose to print out a2 and a4 	
		System.out.println(a[2] + " " + a[4]);
		
	System.out.println("........................");	
		//enhanced for statement
		// statement assigns temp as "a" value and prints out all values of "a" array
		for(int temp : a){
			System.out.println(temp);
		}
	System.out.println(".........................");
			
	int[] x = new int[5]; 
			
			x[3] = 25;
			x[0] = 12;
			
		for(int temp2 : x){
			System.out.println(temp2);
		}
		
    System.out.println("...........................");
    // this example is a String value of stx being assigned 5 values
    // non-assigned values for string are non - values.
    	String[] stx = new String[5];
    	
    	stx[3] = "25";
    	stx[0] = "12"; 
    	for(String temp3 : stx){
    		System.out.println(temp3);
    	}
    // Print string value text
    System.out.println(".............................");
    	String[] st = {"one", "two", "three"};
    	
    	for(String temp4 : st){
    		System.out.println(temp4);
    	}
    	
	}

}
