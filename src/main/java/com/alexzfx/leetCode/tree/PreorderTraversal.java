package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author : Alex
 * Date : 2018/7/18 20:42
 * Description : 144 fin
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class PreorderTraversal {

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        prePrint(root, list);
//        return list;
//    }

    void prePrint(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            prePrint(node.left, list);
            prePrint(node.right, list);
        }
    }

    //迭代求法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return list;
    }

}
