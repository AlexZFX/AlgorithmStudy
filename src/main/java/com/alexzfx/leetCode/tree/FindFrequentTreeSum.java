package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author : Alex
 * Date : 2018/10/13 11:50
 * Description : 508. 出现次数最多的子树元素和
 */
public class FindFrequentTreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = new int[]{1};
        getSumNum(root, map, max);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max[0]) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int getSumNum(TreeNode node, Map<Integer, Integer> map, int[] max) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + getSumNum(node.left, map, max) + getSumNum(node.right, map, max);
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
            if (map.get(sum) > max[0]) {
                max[0] = map.get(sum);
            }
        } else {
            map.put(sum, 1);
        }
        return sum;
    }

}
