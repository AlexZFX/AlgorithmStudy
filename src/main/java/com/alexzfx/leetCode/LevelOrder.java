package com.alexzfx.leetCode;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/7/19 12:36
 * Description : TODO
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return lists;
        }
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            node = queue.removeFirst();


        }
        return lists;
    }
}
