package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/9/11 16:31
 * Description : 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 */
public class Flatten {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode4;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode4.right = treeNode5;
        Flatten flatten = new Flatten();
        flatten.flattenTree(treeNode);
        System.out.println(1);
    }

    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = flattenTree(root.left);
        root.left = null;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = flattenTree(right);
        return root;
    }
}
