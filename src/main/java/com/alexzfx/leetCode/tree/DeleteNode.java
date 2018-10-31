package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/30 10:45
 * Description : 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode tempRoot = new TreeNode(Integer.MAX_VALUE);
        tempRoot.left = root;
        deleteNode(root, tempRoot, key);
        return tempRoot.left;
    }

    private void deleteNode(TreeNode root, TreeNode parent, int key) {
        if (root == null) {
            return;
        }
        if (root.val > key) {
            deleteNode(root.left, root, key);
        } else if (root.val < key) {
            deleteNode(root.right, root, key);
        } else {
            if (root == parent.left) {//左子树根节点
                if (root.left == null && root.right == null) {
                    parent.left = null;
                } else if (root.left == null || root.right == null) {
                    parent.left = root.left == null ? root.right : root.left;
                } else {
                    TreeNode temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    temp.left = root.left;
                    parent.left = root.right;
                    root.left = null;
                    root.right = null;
                }
            } else { // 右子树根节点
                if (root.left == null && root.right == null) {
                    parent.right = null;
                } else if (root.left == null || root.right == null) {
                    parent.right = root.left == null ? root.right : root.left;
                } else {
                    TreeNode temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    temp.left = root.left;
                    parent.right = root.right;
                    root.left = null;
                    root.right = null;
                }
            }
        }
    }


}
