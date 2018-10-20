package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/19 15:28
 * Description : 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor2 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.right = new TreeNode(1);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        LowestCommonAncestor2 lowestCommonAncestor2 = new LowestCommonAncestor2();
        System.out.println(lowestCommonAncestor2.lowestCommonAncestor(node, node.right.left, node.right.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

//    //觉得不太好，解法有点毛病
//    private TreeNode node;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        hasBoth(root, p, q);
//        return node;
//    }
//
//    private boolean hasBoth(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return false;
//        }
//        if (hasBoth(root.left, p, q)) {
//            return true;
//        } else if (hasBoth(root.right, p, q)) {
//            return true;
//        } else if (hasOne(root, p) && hasOne(root, q)) {
//            if (node == null) {
//                node = root;
//            }
//            return true;
//        }
//        return false;
//    }
//
//    private boolean hasOne(TreeNode root, TreeNode p) {
//        if (root == null) {
//            return false;
//        }
//        if (root == p) {
//            return true;
//        } else {
//            return hasOne(root.left, p) || hasOne(root.right, p);
//        }
//    }


}
