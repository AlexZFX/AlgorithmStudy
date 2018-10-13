package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/13 14:36
 * Description : 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int l = Math.min(p.val, q.val);
        int r = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val >= l && root.val <= r) {
                return root;
            }
            if (root.val < l) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}
