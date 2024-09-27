package com.yang.datastructer.linkedlist;

import com.yang.datastructure.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Test;

public class TestSinglyLinkedList {

    @Test
    public void test1(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
//        list.loop2(System.out::println);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }


}
