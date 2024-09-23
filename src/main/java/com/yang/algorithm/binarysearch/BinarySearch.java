package com.yang.algorithm.binarysearch;

public class BinarySearch {


    /**
     * 二分查找基础版本
     *
     * @param a:      待查找的升序数组
     * @param target: 待查找的目标值
     * @return: 找到则返回索引，找不到返回 -1
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;  // 设置指针和初值
        while (i <= j) {  // i-j范围内有东西
            int m = (i + j) /2;
            if (target < a[m]) {  // 目标在左边
                j = m - 1;
            } else if (a[m] < target) { // 目标在右边
                i = m + 1;
            } else {
                return m;  // 找到了
            }
        }
        return -1;
    }

    /*
        问题1：为什么是 i<=j 意味着区间内有为比较的元素，而不是 i<j;
     */
}
