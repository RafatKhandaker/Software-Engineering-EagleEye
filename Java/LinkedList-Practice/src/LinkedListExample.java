
public class LinkedListExample {
	
	
	public static void main(String[] args){
		
	   TestNode intNode = new TestNode(25,null);
	   System.out.println(intNode);
	   
	   TestNode stringNode = new TestNode("Everest", null);
	   System.out.println(stringNode);
	   
//------------------------------------------------------

	   Node list = new Node("Apple");
	   list.next = new Node("Orange"); 
	   list.next.next = new Node("Banana");
	   list.next.next.next = new Node("Carrot");
	   list.next.next.next.next = new Node("Beet");
	   
	// ----- TESTING RECURSIVE FUNCTIONS WITH LinkedList ------

	   System.out.println(listLength(list));
	   System.out.println(searchLinkedList(list,"Apple"));
	   System.out.println(searchLinkedList(list,"Pear"));
	   System.out.println(searchLinkedList(list,"Carrot"));
	   System.out.println(searchLinkedList(list,"Beet"));
	}
	
	private static int listLength(Node list){
		if(list == null ){ return 0; }
		return listLength(list.next) + 1;
	}
	
	private static boolean searchLinkedList(Node head, Object target){
		if (head.data.equals(target)) { return true; }
		if(listLength(head) == 1){ return false; }
		
		return searchLinkedList(head.next, target);
	}

}


	


