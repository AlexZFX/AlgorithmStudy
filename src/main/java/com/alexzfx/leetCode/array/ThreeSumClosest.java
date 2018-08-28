package com.alexzfx.leetCode.array;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/7/24 19:41
 * Description : 16
 * 三数之和最接近 target 的和
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = new int[]{13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1, -15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9, 0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10, 1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7, 0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6};
        int target = -59;
        int end = threeSumClosest.threeSumClosest(nums, target);
        System.out.println(end);
    }

    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        Arrays.sort(nums);
        int left, right, temp;
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - temp) < delta) {
                    sum = temp;
                    delta = Math.abs(target - temp);
                    //不可以全部跳过，可能存在相等时最优。
//                    while (left + 1 < right && nums[left] == nums[left + 1]) {
//                        ++left;
//                    }
//                    while (right - 1 > left && nums[right] == nums[right - 1]) {
//                        --right;
//                    }
                }
                if (temp == target) {
                    return target;
                } else if (temp < target) {
                    ++left;
                } else {
                    --right;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                ++i;
            }

        }
        return sum;
    }
}
