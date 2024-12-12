package com.yang.datastructure.heap;

import java.util.Arrays;

/**
 * 大顶堆
 */
public class E01HeapSort {
    int array[];
    int size;


    public E01HeapSort(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 获取堆顶元素
     *
     * @return 堆顶元素
     */
    public int peek() {

        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    /**
     * 删除指定索引处的元素
     *
     * @param index 索引
     * @return 被删除元素
     */
    public int poll(int index) {
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     * @return 是否添加成功
     */
    public boolean offer(int offered) {
        if (size == array.length) return false;
        up(offered);
        size++;
        return true;
    }

    // 将 offered 元素上浮：直至 offered 小于父元素或到堆顶
    public void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered > array[parent]) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }


    public E01HeapSort(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    // 建堆
    // 优先级队列那个建堆：O(nlogn)
    // Floyd 法建堆：O(n)
    // 1. 找到最后一个非叶子节点
    // 2. 从后向前，对每个节点执行下潜
    private void heapify() {
        // 如何找到最后一个叶子结点 size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    // 将 parent 索引处的元素下潜：与两个孩子较大者交换，直至没孩子或没有孩子比它大
    public void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;

        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }

        if (max != parent) { // 有孩子比父亲大
            swap(max, parent);
            down(max);
        }

    }

    // 交换两个索引处的元素
    public void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 7, 6, 5, 4};
        E01HeapSort maxHeap = new E01HeapSort(array);
        System.out.println(Arrays.toString(maxHeap.array));
        while (maxHeap.size > 1) {
            maxHeap.swap(0, maxHeap.size-1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }

}
