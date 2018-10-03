package com.alexzfx.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/3 10:40
 * Description : 589. N叉树的前序遍历
 */
public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node child : node.children) {
            preorder(child, list);
        }
//        //第一次使用效率很低，应该是遇到加载
//        node.children.forEach(node1 -> preorder(node1,list));
    }

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

    ;
}
