package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/14 12:09
 * Description : 199. 二叉树的右视图
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView(root, res, 0);
        return res;
    }

    private void rightSideView(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() - 1 < level) {
            res.add(node.val);
        } else {
            res.set(level, node.val);
        }
        rightSideView(node.left, res, level + 1);
        rightSideView(node.right, res, level + 1);
    }

}
