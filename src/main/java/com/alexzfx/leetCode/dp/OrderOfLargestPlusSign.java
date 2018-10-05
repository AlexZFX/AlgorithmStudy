package com.alexzfx.leetCode.dp;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/10/5 9:13
 * Description : 764. 最大加号标志
 */
public class OrderOfLargestPlusSign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        for (int i = 0; i < N; i++) {
            // 每个位置对应的左侧可扩展大小
            for (int j = 0, l = 0; j < N; j++) {
                grid[i][j] = Math.min(grid[i][j], l = grid[i][j] == 0 ? 0 : l + 1);
            }
            for (int j = N - 1, r = 0; j >= 0; --j) {
                grid[i][j] = Math.min(grid[i][j], r = grid[i][j] == 0 ? 0 : r + 1);
            }
            for (int j = 0, t = 0; j < N; j++) {
                grid[j][i] = Math.min(grid[j][i], t = grid[j][i] == 0 ? 0 : t + 1);
            }
            for (int j = N - 1, b = 0; j >= 0; j--) {
                grid[j][i] = Math.min(grid[j][i], b = grid[j][i] == 0 ? 0 : b + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }

//    // n3 , 可以用int grid存储当前位置对应最大值，由四个方向决定。
//    public int orderOfLargestPlusSign(int N, int[][] mines) {
//        // 1 为false ，0 为 true
//        boolean[][] grid = new boolean[N][N];
//        for (int[] mine : mines) {
//            grid[mine[0]][mine[1]] = true;
//        }
//        int max = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                max = Math.max(max, helper(grid, i, j, N));
//            }
//        }
//        return max;
//    }
//
//    private int helper(boolean[][] grid, int i, int j, int len) {
//        int result = 0;
//        while (i - result >= 0 && j - result >= 0 && j + result < len && i + result < len && !grid[i - result][j] && !grid[i + result][j] && !grid[i][j + result] && !grid[i][j - result]) {
//            ++result;
//        }
//        return result;
//    }

}
