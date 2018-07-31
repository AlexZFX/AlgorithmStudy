package com.alexzfx.leetCode.array;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/7/31 11:47
 * Description : 4. 两个排序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 均不为空。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //当 m+n 为奇数时，left = right 为中间位置的，为偶数时，left为mid，right为mid+1
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    /**
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k     k为中位数的位置
     * @return
     */
    private int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        //使得前小后大
        if (m > n) return findKth(nums2, nums1, k);
        //小的长度为0，返回大的中位数
        if (m == 0) return nums2[k - 1];
        // k 为 1 取数组中的 0 ，选取2个数组中更小值
        if (k == 1) return Math.min(nums1[0], nums2[0]);
        // i 为小数组的中位，j 为大数组的中位
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        //小数组中位数大于大数组时
        if (nums1[i - 1] > nums2[j - 1]) {
            //删除大数组的前半部分，k 减去大数组前半部分数字个数
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            //删除小数组前半部分，减去i
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }

//    //我的瓜皮解法，复杂度为O(m+n)
//    //一次遍历，遍历到中部时返回，但是要考虑各种不同情况。
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int len = m + n;
//        int mid = len / 2;
//        //是不是偶数
//        boolean even = (len % 2 == 0);
//        int sum = 0, pre = 0, now = 0;
//        for (int i = 0, j = 0; (i + j) < len; ) {
//            //两个都没到结尾
//            if (i < m && j < n) {
//                if (nums1[i] < nums2[j]) {
//                    pre = nums1[i];
//                    ++i;
//                    if (i != m) {
//                        now = Math.min(nums1[i], nums2[j]);
//                    } else {
//                        now = nums2[j];
//                    }
//                } else {
//                    pre = nums2[j];
//                    ++j;
//                    if (j != n) {
//                        now = Math.min(nums1[i], nums2[j]);
//                    } else {
//                        now = nums1[i];
//                    }
//                }
//            } else if (i == m) {
//                pre = nums2[j];
//                ++j;
//                if (j != n) {
//                    now = nums2[j];
//                } else {
//                    now = pre;
//                }
//            } else { // j == n
//                pre = nums1[i];
//                ++i;
//                if (i != m) {
//                    now = nums1[i];
//                } else {
//                    now = pre;
//                }
//            }
//            ++sum;
//            if (sum == mid) {
//                if (even) {
//                    return (double) (pre + now) / 2.0;
//                } else {
//                    return now;
//                }
//            }
//        }
//        return now;
//    }
}
