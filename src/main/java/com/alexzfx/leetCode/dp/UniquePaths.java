package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/6 14:35
 * Description : 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(51, 9));
    }

    public int uniquePaths(int m, int n) {
        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    p[i][j] = 1;
                } else {
                    p[i][j] = p[i - 1][j] + p[i][j - 1];
                }
            }
        }
        return p[m - 1][n - 1];
    }

//    //Time out 递归会导致重复计算
//    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) {
//            return 1;
//        } else {
//            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//        }
//    }
}
