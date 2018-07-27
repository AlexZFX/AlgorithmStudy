package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/7/27 13:53
 * Description : 404 左子树之和
 * 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    //标志位解法
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
//    }
//
//    private int sumOfLeftLeaves(TreeNode node, boolean flag) {
//        if (node == null) {
//            return 0;
//        }
//        if (node.left == null && node.right == null) {
//            return flag ? node.val : 0;
//        }
//        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
//    }
}
