package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/22 13:19
 * Description : 740. 删除与获得点数
 * <p>
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        //max 存储最大值，简化第二次循环
        int len = nums.length, max = Integer.MIN_VALUE;
        int[] numSum = new int[10001];
        for (int i = 0; i < len; i++) {
            numSum[nums[i]] += nums[i];
            max = max > nums[i] ? max : nums[i];
        }
        //类似于小偷偷东西的问题
        int one = numSum[1], two = numSum[2], three = numSum[1] + numSum[3], res = one;
        for (int i = 4; i <= max; i++) {
            res = Math.max(one, two) + numSum[i];
            one = two;
            two = three;
            res = res > three ? res : three;
            three = res;
        }
        return Math.max(three, res);
    }
}
