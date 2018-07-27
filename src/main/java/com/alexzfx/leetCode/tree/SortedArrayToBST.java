package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/7/27 18:12
 * Description : 108 将有序数组转化为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点
 * 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 因为本来就是排序数组，可以利用二分查找的思想，直接找中间的结点为根，
 * 构建高度平衡二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, 0, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, nums.length - 1);
        return root;
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = (right + left) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, left, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, right);
            return node;
        } else {
            return null;
        }
    }
}
