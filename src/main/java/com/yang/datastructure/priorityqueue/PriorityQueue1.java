package com.yang.datastructure.priorityqueue;

import com.yang.datastructure.queue.Queue;

/**
 * 基于无序数组实现
 *
 * @param <E> 队列中元素类型，必须实现 Priority 接口
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[size++] = value;

        return true;
    }

    /**
     * 返回优先级最高的索引
     *
     * @return
     */
    private int selectMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority())
                max = i;
        }
        return max;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        int max = selectMax();

        E e = (E) array[max];

        remove(max);
        return e;
    }

    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }

        array[--size] = null;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        int max = selectMax();
        return (E) array[max];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    public Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }
}
