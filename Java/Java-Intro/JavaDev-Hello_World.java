package J_Dev;

public class Hello_World {

	public static void main(String[] args) {
		// String[] args = default command line
		
		if(args.length != 2); {
			System.out.println("Usage: Hello name age");
			System.exit(1);
		}
		
		String name = args[0];
		
		int age = Integer.parseInt(args[1]); 
		System.out.println("Hello" + name + "You are" + age + "years old.");


	}

}

	}

}
