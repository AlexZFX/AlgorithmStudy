package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/9/14 16:17
 * Description :
 * 106. 从中序与后序遍历序列构造二叉树
 * 105. 从前序与中序遍历序列构造二叉树
 */
//前：中左右 中：左中右 后：左右中
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return buildTree(inorder, postorder, 0, len - 1, 0, len - 1);

    }

//    //从中序与后序遍历序列构造二叉树
//    private TreeNode buildTree(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
//        if (instart > inend || poststart > postend) {
//            return null;
//        } else if (instart == inend) {
//            return new TreeNode(inorder[instart]);
//        }
//        TreeNode treeNode = new TreeNode(postorder[postend]);
//        int inmid = 0;
//        for (int i = instart; i <= inend; i++) {
//            if (inorder[i] == postorder[postend]) {
//                inmid = i;
//            }
//        }
//        int leftLen = inmid - instart;
//        treeNode.left = buildTree(inorder, postorder, instart, inmid - 1, poststart, poststart + leftLen - 1);
//        treeNode.right = buildTree(inorder, postorder, inmid + 1, inend, poststart + leftLen, postend - 1);
//        return treeNode;
//    }

    //从前序(中左右)和中序(左中右)构造二叉树
    private TreeNode buildTree(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) {
            return null;
        } else if (prestart == preend) {
            return new TreeNode(preorder[prestart]);
        }
        TreeNode node = new TreeNode(preorder[prestart]);
        int mid = 0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == preorder[prestart]) {
                mid = i;
            }
        }
        int leftlen = mid - instart;
        node.left = buildTree(preorder, inorder, prestart + 1, prestart + leftlen, instart, mid - 1);
        node.right = buildTree(preorder, inorder, prestart + 1 + leftlen, preend, mid + 1, inend);
        return node;
    }

}
