package day1.examples;

public class Example_Math_Functions {

// All math functions return a double value except for abs, which will return the value that is same as input
	public static void main(String[] args) {
		System.out.println( Math.sqrt(25));          // sq root
		System.out.println( Math.abs(-5));           // absolute value
		System.out.println( Math.sin((1/6)*3.14));   //trig functions in radians 
		System.out.println( Math.cos((1/3)*3.14)); 
		System.out.println( Math.tan((1/4)*3.14));
		System.out.println( Math.asin(.5));        // reverse trig in radians
		System.out.println( Math.acos(.5));
		System.out.println( Math.atan(1));
		System.out.println( Math.exp(1));           // natural e ^ x 
		System.out.println( Math.log(1));           // natural log on base e
		System.out.println( Math.pow(5,2));         //computing x^y 
		System.out.println( Math.floor(5.76));      // computation always round down
		System.out.println( Math.random());         //returns double in the range (0.0 <= x <1.0)
	}

}
