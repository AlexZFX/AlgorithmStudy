package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.*;

/**
 * Author : Alex
 * Date : 2018/10/22 13:14
 * Description : 863. 二叉树中所有距离为 K 的结点
 * <p>
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 */
public class DistanceK {

    //先dfs变成图（舍不得空间，用个map，也很浪费），然后对图bfs
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>(1024);
        dfs(root, null, map);
        bfs(target, map, res, new HashSet<>(), K);
        return res;
    }

    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return;
        }
        map.put(node, parent);
        dfs(node.left, node, map);
        dfs(node.right, node, map);
    }

    private void bfs(TreeNode node, Map<TreeNode, TreeNode> map, List<Integer> res, Set<Integer> set, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            res.add(node.val);
            return;
        }
        set.add(node.val);
        TreeNode parent = map.get(node);
        if (parent != null && !set.contains(parent.val)) {
            bfs(parent, map, res, set, level - 1);
        }
        if (node.left != null && !set.contains(node.left.val)) {
            bfs(node.left, map, res, set, level - 1);
        }
        if (node.right != null && !set.contains(node.right.val)) {
            bfs(node.right, map, res, set, level - 1);
        }
    }

}
