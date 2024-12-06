package com.yang.datastructure.queue;

import java.util.Iterator;

/**
 * 仅用 head，tail 判断空满，head，tail 需要换算成索引值
 * @param <E> 队列中元素类型
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    /*
        求模运算:
        - 如果除数是 2 的 n 次方
        - 那么被除数的后 n 位即为余数（模）
        - 求被除数的后 n 为的方法：与 2^n-1 按位与
     */

    private E[] array;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        // 1. 不是 2 的 n 次方就抛异常
//        if ((capacity & capacity - 1) != 0) {
//            throw new IllegalArgumentException("capacity 必须是 2 的 幂");
//        }
        // 2. 改成最接近的 2^n
        capacity -= 1;
        capacity |= capacity >> 1;
        capacity |= capacity >> 2;
        capacity |= capacity >> 4;
        capacity |= capacity >> 8;
        capacity |= capacity >> 16;
        capacity += 1;
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
//        array[tail % array.length] = value;
        array[tail & array.length -1] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E value = array[head & array.length - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty())  {
            return null;
        }
        return array[head & array.length - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            
            int p = head;
            
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p & array.length - 1];
                System.out.println( p - head);
                p++;
                return value;
            }
        };
    }
}
