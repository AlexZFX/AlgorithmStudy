package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/7/27 10:23
 * Description : 101 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return isSymmetric(root.left, root.right);
        }
        return true;
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
        } else {
            return false;
        }
    }


//    迭代解法
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)
//            return true;
//        Queue<TreeNode> q = new LinkedList();
//
//        q.add(root.left);
//        q.add(root.right);
//        while (!q.isEmpty()) {
//            TreeNode left = q.poll();
//            TreeNode right = q.poll();
//            if (left == null && right == null)
//                continue;
//            if (left == null || right == null || left.val != right.val)
//                return false;
//            q.add(left.left);
//            q.add(right.right);
//            q.add(left.right);
//            q.add(right.left);
//
//        }
//        return true;
//
//    }
}
