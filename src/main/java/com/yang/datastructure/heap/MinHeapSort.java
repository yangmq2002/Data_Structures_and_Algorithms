package com.yang.datastructure.heap;

import java.util.Arrays;

/**
 * 小顶堆排序
 */
public class MinHeapSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 7, 6, 5, 4};
        MinHeap heap = new MinHeap(array);
        System.out.println(Arrays.toString(heap.array));

        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }
        System.out.println(Arrays.toString(heap.array));
    }
}
