package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/12 21:12
 * Description : 637. 二叉树的层平均值
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        getLevelsData(root, sum, num, 1);
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < sum.size(); i++) {
            list.add(sum.get(i) / (double) num.get(i));
        }
        return list;
    }

    private void getLevelsData(TreeNode node, List<Double> sum, List<Integer> num, int level) {
        if (node == null) {
            return;
        }
        if (sum.size() < level) {
            sum.add((double) node.val);
            num.add(1);
        } else {
            sum.set(level - 1, sum.get(level - 1) + node.val);
            num.set(level - 1, num.get(level - 1) + 1);
        }
        getLevelsData(node.left, sum, num, level + 1);
        getLevelsData(node.right, sum, num, level + 1);
    }
}
