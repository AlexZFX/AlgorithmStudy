package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/16 10:47
 * Description : 563. 二叉树的坡度
 * <p>
 * 给定一个二叉树，计算整个树的坡度。
 * <p>
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 */
public class FindTilt {
    public int findTilt(TreeNode root) {
        int[] sum = {0};
        findTilt(root, sum);
        return sum[0];
    }

    private int findTilt(TreeNode node, int[] sum) {
        if (node == null) {
            return 0;
        }
        int left = findTilt(node.left, sum);
        int right = findTilt(node.right, sum);
        sum[0] += Math.abs(left - right);
        return node.val + left + right;
    }
}
