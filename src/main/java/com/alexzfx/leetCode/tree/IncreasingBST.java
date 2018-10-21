package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/21 12:59
 * Description : 897. 递增顺序查找树
 * <p>
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 */
public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        return list.get(0);
    }

    private void inOrder(TreeNode node, List<TreeNode> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node);
            inOrder(node.right, list);
        }
    }

//    //res = inorder(root.left) + root + inorder(root.right)
//    public TreeNode increasingBST(TreeNode root) {
//        return increasingBST(root, null);
//    }
//
//    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
//        if (root == null) return tail;
//        TreeNode res = increasingBST(root.left, root);
//        root.left = null;
//        root.right = increasingBST(root.right, tail);
//        return res;
//    }
}
