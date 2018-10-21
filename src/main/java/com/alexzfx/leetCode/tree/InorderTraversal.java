package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author : Alex
 * Date : 2018/7/18 20:07
 * Description : 94 fin
 * 二叉树的中序遍历
 */
public class InorderTraversal {

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        midPrint(root, list);
//        return list;
//    }

    //迭代求法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // method 2: iteration
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    void midPrint(TreeNode node, List<Integer> list) {
        if (node != null) {
            midPrint(node.left, list);
            list.add(node.val);
            midPrint(node.right, list);
        }
    }


}
