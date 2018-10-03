package com.alexzfx.leetCode.dbfsgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/26 15:07
 * Description : 39. 组合总和
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    //深度优先搜索
    private void combinationSum(int[] candidates, int off, int target, List<List<Integer>> res, List<Integer> temp) {
        for (int i = off; i < candidates.length; i++) {
            if (target - candidates[i] == 0) {
                temp.add(candidates[i]);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            } else if (target - candidates[i] > 0) {
                temp.add(candidates[i]);
                combinationSum(candidates, i, target - candidates[i], res, temp);
                temp.remove(temp.size() - 1);
            } else {
                return;
            }
        }
    }
}
