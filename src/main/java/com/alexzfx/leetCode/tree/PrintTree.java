package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/17 11:11
 * Description : 655. 输出二叉树
 */
public class PrintTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int height = getHeight(root);
        int columns = (int) Math.pow(2, height) - 1;
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                list.add("");
            }
            res.add(list);
        }
        dfs(root, 0, columns - 1, res, 0);

        return res;
    }

    private void dfs(TreeNode root, int left, int right, List<List<String>> res, int level) {
        if (root == null || left > right) {
            return;
        }
        int mid = (left + right) / 2;
        res.get(level).set(mid, String.valueOf(root.val));
        dfs(root.left, left, mid - 1, res, level + 1);
        dfs(root.right, mid + 1, right, res, level + 1);
    }


    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
