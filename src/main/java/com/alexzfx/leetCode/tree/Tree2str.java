package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/15 12:31
 * Description : 606. 根据二叉树创建字符串
 */
public class Tree2str {

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preOrder(t, sb, true);
        return sb.substring(1, sb.length() - 1);
    }

    // isleft 参数 可以用 if 循环 判断即可
    private void preOrder(TreeNode node, StringBuilder sb, boolean isLeft) {
        if (node == null) {
            if (isLeft) {
                sb.append("()");
            }
            return;
        }
        if (node.left == null && node.right == null) {
            sb.append('(').append(node.val).append(')');
        } else {
            sb.append('(').append(node.val);
            preOrder(node.left, sb, true);
            preOrder(node.right, sb, false);
            sb.append(')');
        }
    }
}
