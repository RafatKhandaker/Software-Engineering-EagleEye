public class example_for_loop {

	
	public static void main(String[] args) {
	
	// for(initial value; condition; increment/decrement)
		for(int i = 0; i <= 10; i++){ 
	// i starts at 0 until <=10, i++ = i=i+1
			System.out.println(" i = " + i);
		}
   // ^ to print 0-9 you can remove the equal sign ^
		
// operands for ( -- /++ decrement/increment , * multiply , + add , - subtract ..  *= multiplication ( assignment ) etc..
		for(int j = 10; j > 0; j--){
			System.out.println("j = " + j);
		}
// Practice example with multiplication 
	    for(int k = 1, x = 0; k <= 10; x=k*3, k++ ){
	    	System.out.println("x =" + x);
	    }
	}

}
