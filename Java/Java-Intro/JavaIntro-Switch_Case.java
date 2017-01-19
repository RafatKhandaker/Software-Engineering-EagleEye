public class Example_SwitchCase {

	public static void main(String[] args) {

// in this switch case statement the value of J is 2, which match case 2.
// without the break in statement, it is analogous to a series circuit.
// it will continue printing the following statements without the break; statement
		int j = 2;
		
		// string values can also be used.. string hold text value
		
		switch(j){
		
		case 0:
			System.out.println("Value is 0");
			break;
		case 1:
			System.out.println("Value is 1");
			break;
		case 2:
			System.out.println("Value is 2");
			break;
		case 3:
			System.out.println("Value is 3");
			break;
		default:
			System.out.println("No Value");
			break;
		}

	}

}
