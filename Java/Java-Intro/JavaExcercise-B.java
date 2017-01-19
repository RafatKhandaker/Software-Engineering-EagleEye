public class ExerciseB {

// integer values need to be added to the total. 
// except nums is a string value.
	public static void main(String[] args) {
		
		String[] nums = {"10", "20", "30", "40"};
		
		int total = 0;
		for(String temp : nums){
			//total = total + Integer.parseInt(temp);
	// shorter method:
			total += Integer.parseInt(temp);
		}
		System.out.println("Total = " + total );
	}

}