package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/21 11:58
 * Description : 623. 在二叉树中增加一行
 * <p>
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * <p>
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 */
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        addOneRow(root, v, d, 1);
        return root;
    }

    private void addOneRow(TreeNode node, int v, int d, int level) {
        if (node == null) {
            return;
        }
        if (level == d - 1) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = node.left;
            right.right = node.right;
            node.left = left;
            node.right = right;
        } else {
            addOneRow(node.left, v, d, level + 1);
            addOneRow(node.right, v, d, level + 1);
        }
    }
}
