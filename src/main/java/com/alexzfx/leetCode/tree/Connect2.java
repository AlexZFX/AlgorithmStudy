package com.alexzfx.leetCode.tree;

/**
 * Author : Alex
 * Date : 2018/10/31 8:54
 * Description : 117. 填充同一层的兄弟节点 II
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 说明:
 * <p>
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Connect2 {

    //非递归实现，利用next属性实现层次遍历
    public void connect(TreeLinkNode root) {
        TreeLinkNode temp = new TreeLinkNode(-1), left = temp;
        while (root != null) {
            if (root.left != null) {
                left.next = root.left; // 保留下temp -> 指向下一层的首节点
                left = left.next; // left后移
            }
            if (root.right != null) {
                left.next = root.right; // 向右指
                left = left.next; // left后移
            }
            root = root.next; // 根节点右移
            if (root == null) {
                left = temp;
                root = temp.next;
                temp.next = null;
            }
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
