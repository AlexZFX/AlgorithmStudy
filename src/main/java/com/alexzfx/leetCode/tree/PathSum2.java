package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/15 20:07
 * Description : 113. 路径总和 II
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                res.add(new ArrayList<>(temp));
            }
        }
        dfs(node.left, sum - node.val, res, temp);
        dfs(node.right, sum - node.val, res, temp);
        temp.remove(temp.size() - 1);
    }

}
