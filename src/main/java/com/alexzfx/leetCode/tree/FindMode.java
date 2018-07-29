package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/7/28 18:42
 * Description : 501 二叉树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * BST的中序遍历结果正是排序输出的结果，在这轮遍历中得出结果
 */
public class FindMode {
    private int maxTimes = 0;
    private int tempTime = 0;
    private int tempNum = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<Integer>();
        instOrder(root, list);
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private void instOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        instOrder(node.left, list);
        if (node.val == tempNum) {
            ++tempTime;
        } else {
            tempTime = 1;
            tempNum = node.val;
        }
        if (tempTime == maxTimes) {
            list.add(tempNum);
        } else if (tempTime > maxTimes) {
            maxTimes = tempTime;
            list.clear();
            list.add(tempNum);
        }
        instOrder(node.right, list);
    }


}
