package com.yang.algorithm.recursion_single;

/**
 * 递归求和 n + n-1 ,...+ 1
 */
public class E06Sum {
    public static long sum(long n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    public static void main(String[] args) {
        System.out.println(sum(15000));
    }
}
