package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/29 12:39
 * Description : 45. 跳跃游戏 II
 */
public class Jump {

    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(jump.jump(new int[]{1, 1, 2, 1, 1}));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int res = 1;
        int off = nums[0], max = off;
        if (off >= len - 1) {
            return 1;
        }
        for (int i = 1; i < len; ) {
            while (i <= off && i < len) {
                max = Math.max(max, i + nums[i]);
                ++i;
            }
            //这时还没走下一步，故多加一步
            if (max >= len - 1) {
                return ++res;
            }
            //走下一步
            ++res;
            off = max;
        }
        return res;
    }
}
