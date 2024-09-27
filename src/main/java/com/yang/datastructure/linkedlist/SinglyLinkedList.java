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
        return new Iterator<Integer>() {
            Node p = head;
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
        };
    }

    /**
     * 节点类
     */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加值
     * @param value: 待添加值
     */
    public void addFirst(int value) {
        // 1. 链表为空
        // head = new Node(value, null);
        // 2. 链表非空
        head = new Node(value, head);
    }

    /**
     * 遍历列表
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while(p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历列表
     * @param consumer
     */
    public void loop2(Consumer<Integer> consumer) {
        for(Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

}


