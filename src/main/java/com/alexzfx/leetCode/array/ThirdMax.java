package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/7 8:55
 * Description : 414. 第三大的数
 * <p>
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
public class ThirdMax {

    public static void main(String[] args) {
        ThirdMax max = new ThirdMax();
        int[] nums = new int[]{1, 2};
        System.out.println(max.thirdMax(nums));
    }

    //一遍扫描，也可以3遍扫描直接找。
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, mid = Integer.MIN_VALUE, min = Integer.MIN_VALUE;
        int temp;
        boolean minValue = false;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE) minValue = true;
            if (num > min && num != mid && num != max) {
                min = num;
                if (mid < min) {
                    temp = mid;
                    mid = min;
                    min = temp;
                }
                if (max < mid) {
                    temp = max;
                    max = mid;
                    mid = temp;
                }
            }
        }
        if (minValue) {
            return mid == Integer.MIN_VALUE ? max : min;
        } else {
            return min == Integer.MIN_VALUE ? max : min;
        }
    }
}
