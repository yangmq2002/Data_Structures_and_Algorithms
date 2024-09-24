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
        // 假设循环执行了 L 次
        // 条件判断语句执行了：元素在最左边 L 次，元素在最右边 2*L 次
        while (i <= j) {  // i-j范围内有东西
//            int m = (i + j) /2;
            int m = (i + j) >>> 1;
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
        问题1: 为什么是 i<=j 意味着区间内有为比较的元素，而不是 i<j;
            i == j 意味着 i，j 它们指向的元素也会参与比较
            i < j 只意味着 m 指向的元素参与比较

        问题2: (i + j) / 2 有没有问题？
            数比较大时 i + j 会溢出，导致结果错误

        问题3: 都写成小于号有啥好处？
            该例中，数组是升序排列，写成小于号，与数组顺序一致，谁在左谁在右一目了然

     */

    /**
     * 二分查找改动版
     *
     * @param a:      待查找的升序数组
     * @param target: 待查找的目标值
     * @return: 找到则返回索引，找不到返回 -1
     */
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;  // 第一处
        while (i < j) {           // 第二处
//            int m = (i + j) /2;
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;            // 第三处
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /*
      此处 j 只是作为一个查找的边界，j 指向的元素不在参与查找
      i 指向的元素有可能参与查找

      还能写 i <= j 吗？
        不能，如果查的是一个数组中没有的元素，会陷入死循环
     */


    /**
     * 二分查找-平衡版
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }

    /**
     * 无论在什么地方找到了目标值，都要执行完循环
     * j 只是一个边界，指向的值不参与查找
     * i 指向的参与，并且就是要把 i 逼到要查找的值上
     * 最好情况增加了，最坏情况减少了
     */
}
