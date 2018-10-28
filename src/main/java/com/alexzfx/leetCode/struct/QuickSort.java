package com.alexzfx.leetCode.struct;

import static com.alexzfx.leetCode.struct.SortHelper.swap;

/**
 * Author : Alex
 * Date : 2018/10/19 19:22
 * Description :
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

//    private static int partition(int[] nums, int l, int r) {
//        if (l >= r) {
//            return l;
//        }
//        int key = nums[l];
//        int i = l, j = r;
//        // 整个循环结束是 i = j 且此时必然有 nums[i] = nums[j] < key
//        while (i < j) {
//            //循环结束情况：i = j || nums[j] < key
//            while (i < j && nums[j] >= key) {
//                --j;
//            }
//            // 循环结束情况 i = j || nums[i] > key
//            while (i < j && nums[i] <= key) {
//                ++i;
//            }
//            swap(nums, i, j);
//        }
//        swap(nums, l, j);
//        return j;
//    }

    private static int partition(int[] nums, int l, int r) {
        int i = l, j = r;
        //结束时 i == j 且必然有 左侧小于右侧大于
        while (i < j) {
            // 结束条件 i == j || nums[i] > nums[j];
            while (i < j && nums[i] <= nums[j]) {
                --j;
            }
            //交换后 nums[i] < nums[j];
            swap(nums, i, j);
            //结束条件 i == j || nums[i] > nums[j];
            while (i < j && nums[i] <= nums[j]) {
                ++i;
            }
            //交换后 nums[i] < nums[j];
            swap(nums, i, j);
//             --j 避免 当 nums[i] == nums[j] 时陷入死循环
//            --j;
        }
        return i;
    }

}
