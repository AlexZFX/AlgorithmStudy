package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/30 8:05
 * Description : 222. 完全二叉树的节点个数
 * <p>
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        for (TreeNode node = root; node != null; node = node.left)
            leftDepth++;
        for (TreeNode node = root; node != null; node = node.right)
            rightDepth++;
        if (leftDepth == rightDepth)
            return (1 << leftDepth) - 1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }


}
