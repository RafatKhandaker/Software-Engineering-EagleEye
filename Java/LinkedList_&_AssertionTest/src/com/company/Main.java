package com.company;

// assertions are disabled in Java by default. ( use java -ea or java -enableassertions
public class Main {

public static Node list;

    public static void main(String[] args){
/** 1 **/
        ///   Creating node with data and next value

        TestNode intNode = new TestNode(25,null);
        System.out.println(intNode);

        TestNode stringNode = new TestNode("Everest", null);
        System.out.println(stringNode);

//-----------------------------------------------------------------------------------------
/** 2 **/

        // Node with data input and constructor to set the next value

        list = new Node("Apple");
        list.next = new Node("Orange");
        list.next.next = new Node("Banana");
        list.next.next.next = new Node("Carrot");
        list.next.next.next.next = new Node("Beet");

        // ----- TESTING RECURSIVE FUNCTIONS WITH LinkedList ------

        // listLength method will return the length of the list
        System.out.println(listLength(list));


        // searchLinkedList method will return true if object exists within the list
        System.out.println(searchLinkedList(list,"Apple"));
        System.out.println(searchLinkedList(list,"Pear"));
        System.out.println(searchLinkedList(list,"Carrot"));
        System.out.println(searchLinkedList(list,"Beet"));

//-------------------------------------------------------------------------------------------
 /** 3 **/  // rewriting linkedList append feature to minimize scalability within example 2

       // creating class LinkedList

        LinkedList linkedList = new LinkedList();
            linkedList.append("Apple");
            linkedList.append("Orange");
            linkedList.append("Banana");
            linkedList.append("Carrot");
            linkedList.append("Beet");
    }

//-------------------------------Recursive Methods--------------------------------------------

    public static int listLength(Node list){
        if(list == null ){ return 0; }
        return listLength(list.next) + 1;
    }

    public static boolean searchLinkedList(Node head, Object target){
        if (head.data.equals(target)) { return true; }
        if(listLength(head) == 1){ return false; }

        return searchLinkedList(head.next, target);
    }

}

