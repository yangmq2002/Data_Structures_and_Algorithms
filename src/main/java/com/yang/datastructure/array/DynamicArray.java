package com.yang.datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {

    private int size;  // 逻辑大小，有效内容数
    private int capacity = 8;  // 容量
    private int[] array = new int[capacity];

    /**
     * 向最后位置 [size] 添加元素
     *
     * @param element: 待添加元素
     */
    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    /**
     * 向 [0-size] 位置添加元素
     *
     * @param index:   索引位置
     * @param element: 待添加元素
     */
    public void add(int index, int element) {

        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        size++;

    }

    /**
     * 查询元素
     *
     * @param index: 索引位置，再 [0, size) 区间内
     * @return: 该索引位置的元素
     */
    public int get(int index) {  // [0, size)
        return array[index];
    }

    /**
     * 遍历方法1
     *
     * @param consumer: 遍历集合要执行的操作，入参：每个元素
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            // 提供 array[i]
            // 返回 void
            consumer.accept(array[i]);
        }

    }

    /**
     * 遍历方法2: 迭代器遍历
     *
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int i = 0;

            @Override
            public boolean hasNext() {  // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {  // 返回当前元素,并移向下一个元素
                return array[i++];
            }
        };
    }

    /**
     * 遍历方法3: Stream流
     *
     * @return
     */
    public IntStream stream() {
        // 把普通的方式变成流的方式
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
