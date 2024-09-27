package com.yang.datastructure.linkedlist;

import sun.plugin.viewer.context.IExplorerAppletContext;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> {  // 整体

    private Node head = null;  // 头指针

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类 -> 带名字的内部类
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head;  // 用到了外部类的成员变量，不能加static

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Integer next() {  // 返回当前值，并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        // 内部的变量和外部没有关系，可以加 static
        // 尽量加上
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加值
     *
     * @param value: 待添加值
     */
    public void addFirst(int value) {
        // 1. 链表为空
        // head = new Node(value, null);
        // 2. 链表非空
        head = new Node(value, head);
    }

    /**
     * 遍历列表1
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历列表2
     *
     * @param consumer: 要执行的操作
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    /**
     * 找到最后一个节点
     *
     * @return
     */
    private Node findLast() {

        if(head == null) return null;  // 空链表

        Node p = head;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    /**
     * 尾插法
     * @param value
     */
    public void addLast(int value) {
        Node last = findLast();

        if (last == null) {
            addFirst(value);
            return;
        }

        last.next = new Node(value, null);
    }

    /**
     * 根据所以索引查找
     * @param index: 索引
     * @return: 找到，返回该索引位置节点的值
     * Throws: 找不到则抛异常
     */
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;  // 没找到
    }

    public int get(int index) {
        Node p = findNode(index);

        if (p == null) {
            throw new IllegalArgumentException(String.format("Index %d is out of bounds", index));
        }

        return p.value;
    }

}


