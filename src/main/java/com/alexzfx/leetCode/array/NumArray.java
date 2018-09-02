package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/2 15:30
 * Description : 307. 区域和检索 - 数组可修改
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
//树状数组解法
public class NumArray {

    private int[] array;
    private int[] nums;

    public NumArray(int[] nums) {
        int len = nums.length;
        array = new int[len + 1];
        this.nums = nums;
        for (int i = 0; i < len; i++) {
            change(i + 1, nums[i]);
        }
    }

    //更新时会影响到 i+lowbit(i) 及其递归的offset的位置。
    public void update(int off, int val) {
        int delta = val - nums[off];
        nums[off] = val;
        //array 数组 index++
        ++off;
        change(off, delta);
    }

    public int sumRange(int i, int j) {
        //对于array数组来说要 index+1
        return sum(j + 1) - sum(i);
    }

    private int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += array[i];
            i -= lowbit(i);
        }
        return sum;
    }

    //求出该数字二进制的最后一位1表示的数值，如 6=110 ，则返回2
    private int lowbit(int i) {
        return i & (-i);
    }

    //change为对相应位置数字变化量操作
    private void change(int off, int delta) {
        int len = array.length;
        while (off < len) {
            array[off] += delta;
            off += lowbit(off);
        }
    }

}
