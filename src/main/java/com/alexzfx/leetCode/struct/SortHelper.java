package com.alexzfx.leetCode.struct;

import java.util.Arrays;
import java.util.Random;

import static com.alexzfx.leetCode.struct.MergeSort.mergeSort;

/**
 * Author : Alex
 * Date : 2018/10/20 9:38
 * Description :
 */
public class SortHelper {
    public static void main(String[] args) {
        int[] nums = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            nums[i] = random.nextInt(100);
        }
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
