package com.alexzfx.leetCode.dbfsgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/29 10:39
 * Description : 78 . 子集
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> tempList) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(nums, i + 1, res, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
