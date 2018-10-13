package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/13 13:55
 * Description : 129. 求根到叶子节点数字之和
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return getNums(root, 0);
    }

    private int getNums(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum *= 10;
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return getNums(node.left, sum) + getNums(node.right, sum);
    }
}
