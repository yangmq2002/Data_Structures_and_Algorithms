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
    private int[] array = {};

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

        checkAndGrow();


        // 添加逻辑
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        size++;

    }

    /**
     * 检查容量，必要时扩容
     */
    private void checkAndGrow() {

        // 容量检查
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            // 进行扩容 1.5, 1.618 , 2
            capacity += capacity >> 1;

            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    /**
     * 删除元素
     * @param index: 删除元素的索引
     * @return: 被删除的元素
     */
    public int remove(int index) {  // 假设索引位置是有效的 [0, size)
        int removed = array[index];

        if (index < size - 1) {
            System.arraycopy(array, index+1, array, index, size - index - 1);
        }
        size--;
        return removed;

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
