package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/7/31 19:15
 * Description : 11. 盛最多水的容器
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0, sum = 0;
        int min = 0;
        while (left < right) {
            min = Math.min(height[left], height[right]);
            sum = (right - left) * min;
            if (sum > max) {
                max = sum;
            }
            //哪边小一点就缩小哪一边
            if (height[left] < height[right]) {
                ++left;
                //不会越界，因为到了right的时候必然不小于
                while (height[left] < min) {
                    ++left;
                }
            } else {
                --right;
                while (height[right] < min) {
                    --right;
                }
            }
        }
        return max;
    }
}
