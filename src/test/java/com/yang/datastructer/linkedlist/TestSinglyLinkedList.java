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

    @Test
    public void test2(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
//        list.loop2(System.out::println);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    @Test
    public void test3(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list.get(2));
        System.out.println(list.get(10));
    }


}
