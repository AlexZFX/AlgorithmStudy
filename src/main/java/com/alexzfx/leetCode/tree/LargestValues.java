package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/13 11:28
 * Description : 515. 在每个树行中找最大值
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        largestValues(root, res, 1);
        return res;
    }

    private void largestValues(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() < level) {
            res.add(node.val);
        } else {
            res.set(level - 1, Math.max(node.val, res.get(level - 1)));
        }
        largestValues(node.left, res, level + 1);
        largestValues(node.right, res, level + 1);
    }


}
