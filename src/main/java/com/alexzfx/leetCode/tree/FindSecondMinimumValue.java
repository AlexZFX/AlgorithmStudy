package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.LinkedList;

/**
 * Author : Alex
 * Date : 2018/10/17 14:09
 * Description : 671. 二叉树中第二小的节点
 */
public class FindSecondMinimumValue {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        FindSecondMinimumValue minimumValue = new FindSecondMinimumValue();
        System.out.println(minimumValue.findSecondMinimumValue(node));
    }

    //没考虑第二大为 maxvalue的情况，可用long解决
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        int one = root.val, two = Integer.MAX_VALUE;
        nodes.add(root.left);
        nodes.add(root.right);
        TreeNode node;
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            if (!(node.val == one)) {
                two = Math.min(node.val, two);
            }
            if (node.left != null) {
                nodes.addLast(node.left);
                nodes.addLast(node.right);
            }
        }
        return two == Integer.MAX_VALUE ? -1 : two;
    }
}
