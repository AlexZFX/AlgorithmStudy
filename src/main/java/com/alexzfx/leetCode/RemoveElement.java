package com.alexzfx.leetCode;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/5/4 20:12
 * Description : 27 fin
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] x = {1};
        System.out.println(removeElement(x, 1));
        System.out.println(Arrays.toString(x));
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int r = length - 1;
        int l = 0;
        while (l <= r) { //只是 < 时 只有{1} 1 则输出为1 错误。
            if (nums[r] == val) {
                --r;
                --length;
                continue;
            }
            if (nums[l] == val) {
                nums[l] = nums[r];
                --r;
                --length;
            }
            ++l;
        }
        return length;
    }
}
