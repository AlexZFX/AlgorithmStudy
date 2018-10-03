package com.alexzfx.leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2017/12/29 15:39
 * Description : 442. 数组中重复的数据
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindDuplicates {

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        System.out.println(findDuplicates.findDuplicates(new int[]{2, 2}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[nums[i] % len] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > len << 1) {
                if (i == 0) {
                    result.add(len);
                } else {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
