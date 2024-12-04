package com.yang.algorithm.recursion_multi;

import jdk.internal.org.jline.utils.OSUtils;

/**
 * 递归求斐波那契数列第 n 项
 */
public class E01Fibonacci {

    public static int f(int n) {
        if (n <=1 ) {
            return n;
        }
        return f(n-1) + f(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(f(1));
        System.out.println(f(0));
        System.out.println(f(2));
        System.out.println(f(3));
        System.out.println(f(8));

        }

}
