package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/30 8:40
 * Description : 662. 二叉树最大宽度
 * <p>
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 */
public class WidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(3);
//        node.left.left = new TreeNode(5);
//        node.left.left.left = new TreeNode(1);
//        node.right = new TreeNode(1);
//        node.right.right = new TreeNode(1);
//        node.right.right.right = new TreeNode(1);
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(node));
    }

    public int widthOfBinaryTree(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        getWidth(root, 0, 0, list);
        int max = 0;
        for (int[] ints : list) {
            max = Math.max(max, ints[1] - ints[0]);
        }
        return max + 1;
    }

    private void getWidth(TreeNode node, int level, int num, List<int[]> list) {
        if (node == null) {
            return;
        }
        if (level == list.size()) {
            list.add(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
        }
        int[] temp = list.get(level);
        temp[0] = temp[0] < num ? temp[0] : num;
        temp[1] = temp[1] > num ? temp[1] : num;
        getWidth(node.left, level + 1, num * 2, list);
        getWidth(node.right, level + 1, num * 2 + 1, list);
    }


//    //层序遍历记录树结构，计算index差
//    public int widthOfBinaryTree(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        getWidth(root, list, 0);
//        int max = 0;
//        for (List<Integer> integers : list) {
//            max = Math.max(max, integers.lastIndexOf(-2) - integers.indexOf(-2) + 1);
//        }
//        return max;
//    }
//
//    private void getWidth(TreeNode node, List<List<Integer>> list, int level) {
//        if (list.size() <= level) {
//            list.add(new ArrayList<>());
//        }
//        if (node == null) {
//            if (list.get(level).size() > 0) {
//                list.get(level).add(-1);
//            }
//            if (level < list.size() - 1) {
//                getWidth(null, list, level + 1);
//                getWidth(null, list, level + 1);
//            }
//            return;
//        }
//        list.get(level).add(-2);
//        getWidth(node.left, list, level + 1);
//        getWidth(node.right, list, level + 1);
//    }
}
