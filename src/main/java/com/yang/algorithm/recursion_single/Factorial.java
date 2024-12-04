package com.yang.algorithm.recursion_single;

/**
 * 递归求阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(f(4));
        System.out.println(f(0));
    }

    public static int f(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * f(n - 1);
    }
}
