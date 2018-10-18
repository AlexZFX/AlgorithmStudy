package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/18 9:50
 * Description : 652. 寻找重复的子树
 * <p>
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 */
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(2);
        node.right.left.left = new TreeNode(4);
        node.right.right = new TreeNode(4);
        FindDuplicateSubtrees duplicateSubtrees = new FindDuplicateSubtrees();
        duplicateSubtrees.findDuplicateSubtrees(node);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        preOrder(root, map, res);
        return res;
    }

    private String preOrder(TreeNode node, HashMap<String, Integer> map, List<TreeNode> res) {
        if (node == null) {
            return "#";
        }
        String s = node.val + "," + preOrder(node.left, map, res) + "," + preOrder(node.right, map, res);
        //如果只存在1次 则加入list
        if (map.getOrDefault(s, 0) == 1) {
            res.add(node);
        }
        //不论是否存在 次数 + 1，存在则设置为num+1，避免重复添加到res
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}
