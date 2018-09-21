package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/21 9:24
 * Description : 413. 等差数列划分
 * <p>
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * <p>
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * <p>
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * <p>
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 */
public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        NumberOfArithmeticSlices numberOfArithmeticSlices = new NumberOfArithmeticSlices();
        System.out.println(numberOfArithmeticSlices.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
    }

    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        //等差数列每多一位，相当于 总数量 + dp[i-1] + 1
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int count = 0;
        for (int i : dp) {
            count += i;
        }
        return count;
    }

//    时间 O(n2) 空间 O(n2) 差差差
//    public int numberOfArithmeticSlices(int[] A) {
//        int len = A.length;
//        if (len < 3) {
//            return 0;
//        }
//        int count = 0;
//        // dp[i][j] 表示 从i~j是不是等差数列。
//        boolean[][] dp = new boolean[len][len];
//        for (int i = 1; i < len - 1; i++) {
//            if (A[i] - A[i - 1] == A[i + 1] - A[i]) {
//                dp[i - 1][i + 1] = true;
//                ++count;
//            }
//        }
//        for (int i = 0; i < len - 3; i++) {
//            for (int j = i + 3; j < len; j++) {
//                if (dp[i][j - 1] && (A[j] - A[j - 1] == A[j - 1] - A[j - 2])) {
//                    dp[i][j] = true;
//                    ++count;
//                } else {
//                    dp[i][j] = false;
//                }
//            }
//        }
//        return count;
//    }
}
