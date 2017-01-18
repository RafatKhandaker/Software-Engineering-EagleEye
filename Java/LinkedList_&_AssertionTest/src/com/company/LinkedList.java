package com.company;

/**
 * Created by RedDragon on 1/17/17.
 */
public class LinkedList {

    Node head = null;

    public void append(Object val) {

        if(head == null){
            head = new Node(val);

        }else{
            Node n = head;

            while(n.next != null){
                n = n.next;
            }
            n.next = new Node(val);
        }
    }
}
