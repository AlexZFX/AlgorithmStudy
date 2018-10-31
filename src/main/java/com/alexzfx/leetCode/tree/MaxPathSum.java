package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/31 12:34
 * Description : 124. 二叉树中的最大路径和
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    private int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getMax(node.left);
        int right = getMax(node.right);
        max = Math.max(max, node.val + left + right);
        int lp = node.val + left;
        int rp = node.val + right;
        return Math.max(0, Math.max(lp, rp));
    }


}
