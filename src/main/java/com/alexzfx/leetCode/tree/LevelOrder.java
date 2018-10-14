package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/14 12:34
 * Description :
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }

    private void levelOrder(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() - 1 < level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        levelOrder(node.left, res, level + 1);
        levelOrder(node.right, res, level + 1);
    }
}
