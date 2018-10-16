package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/16 11:25
 * Description : 889. 根据前序和后序遍历构造二叉树
 * <p>
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 * pre 和 post 遍历中的值是不同的正整数。
 */
public class ConstructFromPrePost {
    //前 中左右  后 左右中
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode constructFromPrePost(int[] pre, int[] post, int preS, int preE, int postS, int postE) {
        if (preS > preE) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preS]);
        if (preS == preE) {
            return node;
        }
        // pre 左 start
        int off = pre[preS + 1]; // 暂存 左 start值
        for (int i = postS; i <= postE; i++) {
            // post 左 end
            if (post[i] == off) {
                off = i; // post 中 左end offset
                break;
            }
        }
        node.left = constructFromPrePost(pre, post, preS + 1, preS + off - postS + 1, postS, off);
        node.right = constructFromPrePost(pre, post, preS + off - postS + 2, preE, off + 1, postE - 1);
        return node;
    }

}
