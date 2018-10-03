package com.alexzfx.leetCode.dbfsgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/4 11:16
 * Description : 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> list = permute.permute(new int[]{1, 2, 3, 4});
        System.out.println(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(nums, result, 0);
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> res, int start) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                //从start开始，保证将自身及后面的第一层等添加进去
                swap(nums, i, start);
                permute(nums, res, start + 1);
                //回溯
                swap(nums, i, start);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
