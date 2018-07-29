package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author : Alex
 * Date : 2018/7/29 14:18
 * Description : 653 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        if (root == null) {
            return false;
        }
        return hasTarget(root, k, set);
    }

    private boolean hasTarget(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return hasTarget(node.left, k, set) || hasTarget(node.right, k, set);
    }
}
