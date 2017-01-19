/* This Program will perform some mathematical computations and display results. The purpose of this program is to 
 * calculate the lag time of the computer to process this program's task. The task of the computer will be to calculate
 * some mathematical functions. The Run time is expected to be different every time the program is executed, this is due to the 
 * variable process running on your computer and not due to the program itself.*/

package day3.Math_Intermediate;

public class Example_Calculate_Process_Time {

	public static void main(String[] args) {
		long startTime; // Starting time of the program, in milliseconds.
		long endTime; //Time when computations are done, in milliseconds.
		double time;   // Time difference, in seconds.
		
		startTime = System.currentTimeMillis(); // system is a class that contains a method, or subroutine currentTimeMillis
		
		double width, height, hypotenuse; // sides of a triangle
		width = 42.0;
		height = 17.0; 
		
		hypotenuse = Math.sqrt( width*width + height*height );
		
			System.out.print("A triangle with sides 42 and 17 has hypotenuse:  ");
			System.out.println(hypotenuse);
			System.out.println("\nMathematically, sin(x)*sin(x) + " + "cos(x)*cos(x) - 1 should be 0.");
			System.out.println("Let's check this for x = 1:");
			System.out.print("          sin(1)*sin(1) + cos(1)*cos(1) - 1 is ");
			System.out.println( Math.sin(1)*Math.sin(1)+ Math.cos(1)*Math.cos(1) - 1);
			System.out.println();
			System.out.println("(There can be round-off errors when" + "computing with real numbers!)");
			System.out.print("\nHere is a random number:  ");
			System.out.println(  Math.random() );
			
		endTime = System.currentTimeMillis();
		time = (endTime - startTime) / 1000.0;   // display time in seconds
		
			System.out.print("\nRun time in seconds was:  ");
			System.out.println(time);
		
	}  // end main()
  
}    // end class
