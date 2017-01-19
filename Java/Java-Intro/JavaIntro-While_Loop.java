public class example_While_Loop {


	public static void main(String[] args) {
// In this example X starts at -10; while loop executes as long as x <=	0
// system will proceed to printout x value and afterwards increment it by 1
// loop will continue until x <=0
		
		int x = -10;
		while(x <= 0){
			System.out.println("x = " + x);
			x++; 
			// increment can be written in many ways
			// x = x + 1;
			// x += 1
// other operands: 
			// + , - , * , / , % , ++ (increment), -- (Decrement)
			// += addition assignment; etc ..mod.. 
		}

	}

}
