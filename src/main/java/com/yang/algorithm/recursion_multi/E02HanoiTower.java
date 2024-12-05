package com.yang.algorithm.recursion_multi;

import java.util.LinkedList;

/**
 * 递归求解汉诺塔
 */
public class E02HanoiTower {
    // 三根柱子
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    // 3, 2, 1
    static void init(int n) {
        for (int i = n; i > 0; i--) {
            a.addLast(i);
        }
    }

    /**
     * @param n 圆盘个数
     * @param a 源
     * @param b 借
     * @param c 目
     */
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());  // 中间
        print();
        move(n - 1, b, a, c);

    }


    public static void main(String[] args) {
        init(4);
        print();

        move(4, a, b, c);


    }

    private static void print() {
        System.out.println("----------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
