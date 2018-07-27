package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Author : Alex
 * Date : 2018/7/18 20:44
 * Description : 145 fin
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class PostorderTraversal {

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        backPrint(root, list);
//        return list;
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }

    void backPrint(TreeNode node, List<Integer> list) {
        if (node != null) {
            backPrint(node.left, list);
            backPrint(node.right, list);
            list.add(node.val);
        }
    }

}
