package com.alexzfx.leetCode.tree;

/**
 * Author : Alex
 * Date : 2018/10/22 13:05
 * Description :
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
