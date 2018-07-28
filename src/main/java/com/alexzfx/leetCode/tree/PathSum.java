package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/7/28 15:59
 * Description : 437 路径总和3
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 自生sum递减结果 + 左右子树sum满足度计算
        return subPathSum(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);
    }

    private int subPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return 1 + subPathSum(root.left, 0) + subPathSum(root.right, 0);
        }
        return subPathSum(root.left, sum - root.val) + subPathSum(root.right, sum - root.val);
    }

}
