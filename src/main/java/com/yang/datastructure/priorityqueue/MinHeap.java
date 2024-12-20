package com.yang.datastructure.priorityqueue;

import com.yang.datastructure.linkedlist.ListNode;

import java.util.List;

/**
 * 小顶堆
 */
public class MinHeap {

    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }

    public boolean offer(ListNode offered) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }

        swap(0, size - 1);
        size--;
        ListNode e = array[size];
        array[size] = null; // help GC

        // 下潜
        down(0);

        return e;
    }

     private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent; // 假设父元素优先级最高
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != parent) { // 有孩子比父亲大
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int i, int j) {
        ListNode t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }


}
