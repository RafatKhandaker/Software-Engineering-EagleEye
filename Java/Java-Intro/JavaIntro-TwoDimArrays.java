public class Example_TwoDimArray {

	public static void main(String[] args) {
	// assigning an array with 4 rows and 3 columns
		int[][] TwoDim = new int[4][3];
	
	//You can assign a value to the grid arrow a value at position 2,1 = 10
		//like this : 
		//TwoDim[2][1] = 10

		
//  You can assign arrays with coordinates particular values by using a loop within a loop
// in this array the inside for loop for j will execute for all values of i=0 and will increase 
// temp value will increase by 10 for every increment value of j.. filling up the first horizontal  
// filling up the first horizontal row and continue to the second row.. so on. 
		int temp = 10;
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3; j++){
				
				TwoDim[i][j] = temp;
				temp += 10;
		}
	}
	
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3; j++){
	// To print out the array from top to bottom		
			//	System.out.println(TwoDim[i][j]);
	// To Print out the array in a matrix
				System.out.print(TwoDim[i][j] + " ");
			}
			System.out.println();
			
	//^^ so the loop continues in the j portion
	//^^ before going back to " i " for loop, it printed a new line.
	}
	
	
  }
} 
		

