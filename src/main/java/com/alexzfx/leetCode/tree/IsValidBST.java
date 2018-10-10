package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/10 10:18
 * Description : 98. 验证二叉搜索树
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);
        treeNode.right.left.left = new TreeNode(2);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

//    //二叉搜索树的中序遍历一定是递增的
//    public boolean isValidBST(TreeNode root) {
//        List<Integer> inorder = new ArrayList<>();
//        inOrder(root, inorder);
//        for (int i = 1; i < inorder.size(); i++) {
//            if (inorder.get(i) <= inorder.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void inOrder(TreeNode node, List<Integer> res) {
//        if (node != null) {
//            inOrder(node.left, res);
//            res.add(node.val);
//            inOrder(node.right, res);
//        }
//    }


}
