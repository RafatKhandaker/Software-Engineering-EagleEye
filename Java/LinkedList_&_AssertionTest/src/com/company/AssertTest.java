package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.company.Main.listLength;
import static com.company.Main.searchLinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by RedDragon on 1/18/17.
 */
public class AssertTest {

    static Node list = null;

    @BeforeAll
    public static void createDataTest(){
        list = new Node("Apple");
        list.next = new Node("Orange");
        list.next.next = new Node("Banana");
        list.next.next.next = new Node("Carrot");
        list.next.next.next.next = new Node("Beet");
    }

    @Test
    public void ListLengthTest(){
        assertEquals(listLength(list),5);
    }

    @Test
    public void SearchLinkedListTest(){
        assertEquals(searchLinkedList(list,"Apple"), true);
    }
}