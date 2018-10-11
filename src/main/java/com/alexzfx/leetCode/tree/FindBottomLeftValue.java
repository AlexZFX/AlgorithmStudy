package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/11 13:34
 * Description : 513. 找树左下角的值
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findBottomLeftValue(root, list, 1);
        return list.get(list.size() - 1);
    }

    private void findBottomLeftValue(TreeNode node, List<Integer> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() < level) {
            list.add(node.val);
        }
        findBottomLeftValue(node.left, list, level + 1);
        findBottomLeftValue(node.right, list, level + 1);
    }
}
