package com.yang.datastructure.stack;

import java.util.Stack;

/**
 * 双栈模拟队列
 * 调用 push、pop 等方法的次数最多 100
 */
public class E04Leetcode232 {
    /*
        队列头        队列尾
        b
        顶   底     底   顶
        s1              s2

        队列尾添加
            s2.push(a)
            s2.push(b)

        队列头移除
            先把 s2 的所有元素移动到 s1
            s1.pop()

     */

    ArrayStack<Integer> s1 = new ArrayStack<>(100);
    ArrayStack<Integer> s2 = new ArrayStack<>(100);

    /**
     * 向队列尾部添加
     *
     * @param x
     */
    public void push(int x) {
        s2.push(x);
    }

    /**
     * 从队头移除
     *
     * @return
     */
    public int pop() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        return s1.pop();
    }

    /**
     * 从队头获取
     *
     * @return
     */
    public int peek() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
