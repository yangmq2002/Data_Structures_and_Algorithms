package com.yang.algorithm.binarysearch;

public class LinearSearch {

    /**
     * 线性查找
     * @param a: 待查找的升序数组
     * @param target: 待查找的目标值
     * @return
     *        找到则返回索引
     *        找不到则返回 -1
     */
    public static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }



}
