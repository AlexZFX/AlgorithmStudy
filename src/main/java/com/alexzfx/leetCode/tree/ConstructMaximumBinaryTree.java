package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/10 11:17
 * Description : 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        } else if (l > r) {
            return null;
        }
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(nums, l, index - 1);
        node.right = constructMaximumBinaryTree(nums, index + 1, r);
        return node;
    }
}
