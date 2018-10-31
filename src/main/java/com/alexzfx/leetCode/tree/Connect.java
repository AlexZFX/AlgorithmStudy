package com.alexzfx.leetCode.tree;

/**
 * Author : Alex
 * Date : 2018/10/22 13:05
 * Description : 116. 填充同一层的兄弟节点
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 说明:
 * <p>
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 */
public class Connect {
    public void connect(TreeLinkNode root) {
        connect(root, null);
    }

    private void connect(TreeLinkNode node, TreeLinkNode next) {
        if (node == null) {
            return;
        }
        node.next = next;
        connect(node.left, node.right);
        if (next == null) {
            connect(node.right, null);
        } else {
            connect(node.right, node.next.left);
        }
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
