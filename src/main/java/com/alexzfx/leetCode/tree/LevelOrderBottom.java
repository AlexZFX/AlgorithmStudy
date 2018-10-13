package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/12 21:36
 * Description : 107. 二叉树的层次遍历 II
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(root, 1, res);
        return res;
    }

    private void levelOrderBottom(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() < level) {
            res.add(0, new ArrayList<>());
        }

        res.get(res.size() - level).add(root.val);
        levelOrderBottom(root.left, level + 1, res);
        levelOrderBottom(root.right, level + 1, res);
    }


}
