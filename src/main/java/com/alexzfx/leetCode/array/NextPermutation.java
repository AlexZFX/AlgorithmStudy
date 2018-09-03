package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/8/29 10:46
 * Description : 31. 下一个排列
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{5, 1, 1};
        nextPermutation.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //数字i出现在 nums[i] < nums[i+1] ，且后面的数字均为倒序排序的
    //从左往右，找到第i个数字后比他大且最小的数字交换后，对i后方的数字排序
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len;
        //只需要一遍遍历，找到nums[i] < nums[i+1] 的位置即可确认i的位置
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i >= 0) {
            index = i + 1;
            while (index < len - 1) {
                if (nums[i] < nums[index + 1]) {
                    ++index;
                } else {
                    break;
                }
            }
            swap(nums, i, index);
            reverse(nums, i + 1);
            return;
        }
        reverse(nums, 0);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
