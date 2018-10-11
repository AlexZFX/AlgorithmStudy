package com.alexzfx.leetCode.tree;

import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/11 11:34
 * Description : 559. N叉树的最大深度
 */
public class MaxDepthN {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return 1 + max;
    }
}
