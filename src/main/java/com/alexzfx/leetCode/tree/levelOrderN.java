package com.alexzfx.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/19 13:02
 * Description : 429. N叉树的层序遍历
 * <p>
 * 给定一个N叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class levelOrderN {

    //递归解法
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        leverOrder(root, 1, res);
        return res;
    }

    private void leverOrder(Node node, int lev, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (lev > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(lev - 1).add(node.val);
        node.children.forEach(v -> leverOrder(v, lev + 1, res));
    }

//    //队列解法
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root == null) {
//            return Collections.emptyList();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.add(root);
//        Node temp;
//        int count1 = 1, count2 = 0;
//        while (!queue.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < count1; i++) {
//                temp = queue.removeFirst();
//                list.add(temp.val);
//                temp.children.forEach(queue::addLast);
//                count2 += temp.children.size();
//            }
//            res.add(list);
//            count1 = count2;
//            count2 = 0;
//        }
//        return res;
//    }

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
}
