package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/17 15:00
 * Description : 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        if (l > r) {
            return Collections.emptyList();
        }
        if (l == r) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(l));
            return list;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = generateTrees(l, i - 1);
            List<TreeNode> right = generateTrees(i + 1, r);
            TreeNode node;
            if (left.size() == 0) {
                for (TreeNode rightNode : right) {
                    node = new TreeNode(i);
                    node.right = rightNode;
                    res.add(node);
                }
            } else if (right.size() == 0) {
                for (TreeNode leftNode : left) {
                    node = new TreeNode(i);
                    node.left = leftNode;
                    res.add(node);
                }
            } else {
                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode : right) {
                        node = new TreeNode(i);
                        node.left = leftNode;
                        node.right = rightNode;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
}
