package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/11 11:13
 * Description : 814. 二叉树剪枝
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.right = pruneTree(root.right);
        root.left = pruneTree(root.left);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

}
