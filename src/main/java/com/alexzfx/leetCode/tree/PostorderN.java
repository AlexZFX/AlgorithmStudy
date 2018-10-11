package com.alexzfx.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/11 11:44
 * Description :
 */
public class PostorderN {

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

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorder(child, list);
        }
        list.add(root.val);
    }


}
