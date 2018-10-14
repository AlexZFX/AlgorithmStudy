package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/14 12:18
 * Description : 173. 二叉搜索树迭代器
 */
public class BSTIterator {

    private List<Integer> array;
    private int off;

    public BSTIterator(TreeNode root) {
        array = new ArrayList<>();
        off = 0;
        inOrder(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return off < array.size();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return array.get(off++);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        array.add(node.val);
        inOrder(node.right);
    }
}
