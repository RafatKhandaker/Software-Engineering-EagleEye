
public class Example_And_Or {

	public static void main(String[] args) {
	// you can declare multiple variables then assign values after
		int x, y, a, b;
		x = 10;
		y = -10;
		a = -10;
		b = 10;
		
		// && and
// purpose is to show that two values are compared in the statement
	
		if(x > 0 && y > 0){
			System.out.println(" Both nums are +ve");
		}else if(x > 0 || y > 0){
			System.out.println(" atleast one num is +ve");
		}else{
			System.out.println(" Both nums are -ve ");
		}
// single handed  & , |  can be used. the difference is that if first condition fails
// the second condition will not be checked. ( for double ) 
//As with the single condition, both conditions will be checked
		
		
		if(a > 0 & b > 0){
			System.out.println(" Both nums are +ve");
		}else if(a > 0 | b > 0){
			System.out.println(" atleast one num is +ve");
		}else{
			System.out.println(" Both nums are -ve ");
		}
	}

}
