package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/13 10:47
 * Description : 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return res;
        }
        binaryTreePaths(root.left, res, new StringBuilder(sb.toString()));
        binaryTreePaths(root.right, res, new StringBuilder(sb.toString()));
        return res;
    }

    private void binaryTreePaths(TreeNode node, List<String> res, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append("->").append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
        }
        binaryTreePaths(node.left, res, new StringBuilder(sb.toString()));
        binaryTreePaths(node.right, res, new StringBuilder(sb.toString()));
    }

}
