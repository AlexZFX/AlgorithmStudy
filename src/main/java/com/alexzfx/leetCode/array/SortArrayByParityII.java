package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/10/14 9:30
 * Description : 922. 按奇偶排序数组 II
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length, i = 0, j = 1, temp;
        while (i < len && j < len) {
            while (i < len && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < len && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < len && j < len) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
