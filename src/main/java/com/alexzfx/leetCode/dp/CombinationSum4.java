package com.alexzfx.leetCode.dp;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/10/24 15:34
 * Description : 377. 组合总和 Ⅳ
 * <p>
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * <p>
 * 请注意，顺序不同的序列被视作不同的组合。
 */
public class CombinationSum4 {

    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        System.out.println(combinationSum4.combinationSum4(new int[]{1, 2, 3}, 5));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        // dp[i] 表示 target = i 时的组合总数
        int[] dp = new int[target + 1];
        dp[0] = 1; // 对应 num = i 时的 1
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else {
                    //对于每个 num，dp[i-num]都与其对应和为 i
                    //相当于每种情况都是在最后一位加上num，不用考虑排序情况
                    //排序体现在 4 += 1 + dp[3]，4 += 3 + dp[1];
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

//    private int sum = 0;
//
//    public int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
//        dfs(nums,target);
//        return sum;
//    }
//
//    // 直接dfs复杂度 n^n TLE
//    private void dfs(int[] nums, int target) {
//        if (target == 0) {
//            ++sum;
//            return;
//        } else if (target < 0) {
//            return;
//        }
//        for (int num : nums) {
//            dfs(nums, target - num);
//        }
//    }
}
