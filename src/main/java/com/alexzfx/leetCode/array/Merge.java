package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/7 20:22
 * Description : 88. 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * tip: 从后向前写入
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Merge merge = new Merge();
        merge.merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, sum = m + n - 1;
        for (int i = sum; i >= 0; i--) {
            if (index1 < 0) {
                nums1[i] = nums2[index2];
                --index2;
            } else if (index2 < 0) {
                nums1[i] = nums1[index1];
                --index1;
            } else if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums1[index1];
                --index1;
            } else {
                nums1[i] = nums2[index2];
                --index2;
            }
        }
    }
}
