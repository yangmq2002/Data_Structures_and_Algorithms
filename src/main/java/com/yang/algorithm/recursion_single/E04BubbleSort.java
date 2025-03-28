package com.yang.algorithm.recursion_single;

import java.util.Arrays;


/**
 * 递归冒泡排序
 * <ul>
 *     <li>将数组划分成两部分 [0 .. j] [j+1 .. a.length-1]</li>
 *     <li>左边 [0 .. j] 是未排序部分</li>
 *     <li>右边 [j+1 .. a.length-1] 是已排序部分</li>
 *     <li>未排序区间内, 相邻的两个元素比较, 如果前一个大于后一个, 则交换位置</li>
 * </ul>
 */
public class E04BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length-1);
    }

    /**
     * 递归函数 在范围 [0 .. j] 内冒泡最大元素到右侧
     * @param a 数组
     * @param j 未排序区域的右边界
     */
    private static void bubble(int[] a, int j) {

        if (j == 0) {
            return;
        }

        // 发生交换，则把 i 的值赋给 x
        // x记录最后一次发生交换的 i 的位置，后面不交换，说明后面有序
        // 把 x 作为右边边界即可
        int x = 0;

        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }

        bubble(a, x);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
