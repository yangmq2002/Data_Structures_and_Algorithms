package com.yang.datastructer.array;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.Arrays;

public class TestCacheLine {

    public static void ij(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void ji(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    /*
        CPU      缓存     内存
        皮秒              纳秒
                 64字节
                 缓存行 cache line

                 空间局部性
     */

    public static void main(String[] args) {
        int rows = 1_000_000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch sw = new StopWatch();

        sw.start("ij");
        ij(a, rows, columns);
        sw.stop();

        sw.start("ji");
        ji(a, rows, columns);
        sw.stop();

        System.out.println(sw.prettyPrint());
    }

    @Test
    public void testlc() {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

         int i = 0;
        int j = 0;
        int[] sorted = new int[m+n];
        while (i<m || j<n) {
            int tmp = 0;
            if(i==m) {
                tmp = nums2[j++];
            } else if (j == n ) {
                tmp = nums1[i++];
            } else if(nums1[i] < nums2[j]) {
                tmp = nums1[i++];
            } else {
                tmp = nums2[j++];
            }

            sorted[i + j -1] = tmp;
        }

        // for(i = 0; i<m+n; i++) {
        //     nums1[i] = sorted[i];
        // }

        nums1 = sorted;
        System.out.println(Arrays.toString(nums1));
    }
}
