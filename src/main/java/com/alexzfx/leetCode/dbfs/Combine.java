package com.alexzfx.leetCode.dbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/29 9:40
 * Description : 77. 组合
 */
public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 1, k, res, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int start, int k, List<List<Integer>> res, List<Integer> tempList) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            dfs(n, i + 1, k, res, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

}
