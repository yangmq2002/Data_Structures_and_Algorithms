package com.yang.datastructer.linkedlist;

import com.yang.datastructure.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    public void test4(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.insert(0, 6);
        list.loop2(System.out::println);
    }

    @Test
    @DisplayName("测试 removeFirst")
    public void test5(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        for(Integer integer : list){
            System.out.println(integer);
        }
        System.out.println("==========");

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        for(Integer integer : list){
            System.out.println(integer);
        }

    }

    @Test
    @DisplayName("测试 remove")
    public void test6() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        for (Integer integer : list) {
            System.out.println(integer);
        }

        list.remove(0);
        System.out.println("==========");
        list.loop2(System.out::println);
    }


}
