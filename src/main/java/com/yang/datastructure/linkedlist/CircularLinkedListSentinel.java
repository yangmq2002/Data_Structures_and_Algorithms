package com.yang.datastructure.linkedlist;

import java.util.Iterator;

/**
 * 环形链表，循环链表
 */
public class CircularLinkedListSentinel implements Iterable<Integer>{


    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.next = next;
            this.value = value;
            this.prev = prev;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public CircularLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 添加到第一个
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到最后一个
     */
    public void addLast(int value) {
        Node b = sentinel;
        Node a = sentinel.prev;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除第一个
     * @return
     */

      @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}
