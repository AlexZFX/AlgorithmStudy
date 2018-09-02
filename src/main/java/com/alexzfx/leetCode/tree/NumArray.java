package com.alexzfx.leetCode.tree;

/**
 * Author : Alex
 * Date : 2018/9/2 11:07
 * Description : 307. 区域和检索 - 数组可修改
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
//线段树解法。
public class NumArray {

    private NumTree numTree;

    private class NumTree {
        int sum;
        int start, end;

        NumTree left, right;

        NumTree(int[] nums, int start, int end) {
            if (nums == null || nums.length == 0) {
                return;
            }
            this.start = start;
            this.end = end;
            if (start == end) {
                sum = nums[start];
                this.left = null;
                this.right = null;
            } else {
                int mid = (start + end) / 2;
                this.left = new NumTree(nums, start, mid);
                this.right = new NumTree(nums, mid + 1, end);
                this.sum = this.left.sum + this.right.sum;
            }
        }
    }

    public NumArray(int[] nums) {
        numTree = new NumTree(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(numTree, i, val);
    }

    private void update(NumTree node, int pos, int val) {
        if (node.start == pos && node.end == pos) {
            node.sum = val;
        } else {
            int mid = (node.start + node.end) / 2;
            if (pos > mid) {
                update(node.right, pos, val);
            } else {
                update(node.left, pos, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(numTree, i, j);
    }

    private int sumRange(NumTree node, int i, int j) {
        if (node.start == i && node.end == j) {
            return node.sum;
        }
        int mid = (node.start + node.end) / 2;
        if (j <= mid) {
            return sumRange(node.left, i, j);
        } else if (i > mid) {
            return sumRange(node.right, i, j);
        } else {
            return sumRange(node.left, i, mid) + sumRange(node.right, mid + 1, j);
        }
    }
}
