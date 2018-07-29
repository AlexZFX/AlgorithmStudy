package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author : Alex
 * Date : 2018/7/29 14:58
 * Description : 872. 叶子相似的树
 * <p>
 * 考虑一个二叉树的所有叶子。这些叶子的值按从左到右的顺序排列形成一个 叶值序列
 * 举个例子，给定一个如上图所示的树，其叶值序列为 (6, 7, 4, 9, 8) 。
 * 如果两个二叉树的叶值序列相同，我们就认为它们是 叶相似的。
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，返回 true；否则返回 false 。
 */
public class LeafSimilar {

    //非递归形式的解决
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //两树相同或都为空时
        if (root1 == root2) {
            return true;
        }
        int tempNum = 0;
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //从左往右遍历
        while (root1 != null || !stack.empty()) {
            while (root1 != null) {
                stack.push(root1);
                root1 = root1.left;
            }
            root1 = stack.pop();
            //是叶子的时候将值加入list
            if (root1.left == null && root1.right == null) {
                list.add(root1.val);
            }
            root1 = root1.right;
        }
        while (root2 != null || !stack.empty()) {
            while (root2 != null) {
                stack.push(root2);
                root2 = root2.left;
            }
            root2 = stack.pop();
            //是叶子的时候对值进行比对
            if (root2.left == null && root2.right == null) {
                if (tempNum < list.size()) {
                    if (list.get(tempNum++) != root2.val) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            root2 = root2.right;
        }
        return true;
    }
}
