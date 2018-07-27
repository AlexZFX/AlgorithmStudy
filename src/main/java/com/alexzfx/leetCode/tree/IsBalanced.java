package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/7/27 21:06
 * Description : 110 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 按先序遍历
 * 直接先判断根节点平衡，再从左右判断，相当于做了许多重复计算子节点高度
 * <p>
 * 应该按后续遍历计算
 */
public class IsBalanced {

    private boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return balance;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1) {
            balance = false;
        }
        return 1 + Math.max(left, right);
    }
}
