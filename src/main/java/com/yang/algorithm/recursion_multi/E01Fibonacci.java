package com.yang.algorithm.recursion_multi;

import jdk.internal.org.jline.utils.OSUtils;

import java.util.Arrays;

/**
 * 递归求斐波那契数列第 n 项
 */
public class E01Fibonacci {

    /**
     * 使用 Memoization(记忆法，也称备忘录法) 改进
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;


        return f(n, cache);
    }


    public static int f(int n, int[] cache) {
        /*if (n <= 1) {
            return n;
        }*/

        if (cache[n] != -1)
            return cache[n];

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x+y;
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(13));

    }

}
