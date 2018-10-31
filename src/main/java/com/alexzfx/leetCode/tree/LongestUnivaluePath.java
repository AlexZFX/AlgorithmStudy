package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/30 20:05
 * Description : 687. 最长同值路径
 * <p>
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class LongestUnivaluePath {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePath(root, Integer.MIN_VALUE);
        return max;
    }

    private int longestUnivaluePath(TreeNode node, int key) {
        if (node == null) {
            return 0;
        }
        int left = longestUnivaluePath(node.left, node.val);
        int right = longestUnivaluePath(node.right, node.val);
        max = Math.max(left + right, max);
        if (node.val != key) {
            return 0;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
