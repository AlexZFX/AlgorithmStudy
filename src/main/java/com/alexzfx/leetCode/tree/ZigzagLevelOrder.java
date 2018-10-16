package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/16 11:13
 * Description : 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0, false);
        return res;
    }

    private void levelOrder(TreeNode node, List<List<Integer>> res, int level, boolean rev) {
        if (node == null) {
            return;
        }
        if (res.size() - 1 < level) {
            res.add(new ArrayList<>());
        }
        if (rev) {
            res.get(level).add(0, node.val);
        } else {
            res.get(level).add(node.val);
        }
        levelOrder(node.left, res, level + 1, !rev);
        levelOrder(node.right, res, level + 1, !rev);
    }
}
