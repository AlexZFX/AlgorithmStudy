package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/14 16:37
 * Description : 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {

    private int sum = 0;

    // 右中左倒序添加
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }


//    利用中序遍历，瓜解法
//    private int i = 0;
//
//    public TreeNode convertBST(TreeNode root) {
//        List<Integer> vals = new ArrayList<>();
//        inOrder(root, vals);
//        inOrderTwo(root, vals);
//        return root;
//    }
//
//    private void inOrderTwo(TreeNode root, List<Integer> vals) {
//        if (root == null) {
//            return;
//        }
//        inOrderTwo(root.left, vals);
//        for (int j = i + 1; j < vals.size(); j++) {
//            root.val += vals.get(j);
//        }
//        ++i;
//        inOrderTwo(root.right, vals);
//    }
//
//    private void inOrder(TreeNode node, List<Integer> vals) {
//        if (node == null) {
//            return;
//        }
//        inOrder(node.left, vals);
//        vals.add(node.val);
//        inOrder(node.right, vals);
//    }

}
