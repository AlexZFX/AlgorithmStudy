package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/11 12:36
 * Description : 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        inOrder(root, res, k);
        return res[0];
    }

    private boolean inOrder(TreeNode root, int[] res, int k) {
        if (root == null) {
            return false;
        }
        if (inOrder(root.left, res, k)) {
            return true;
        }
        ++res[0];
        if (res[0] == k) {
            res[0] = root.val;
            return true;
        }
        return inOrder(root.right, res, k);
    }
}
