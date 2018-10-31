package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/30 19:50
 * Description : 865. 具有所有最深结点的最小子树
 * <p>
 * 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 */
public class SubtreeWithAllDeepest {

    //左右depth相等则说明该结点为所求结点。
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            return root;
        } else if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
}
