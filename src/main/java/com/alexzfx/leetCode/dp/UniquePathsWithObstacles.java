package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/6 15:42
 * Description : 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
//        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid = new int[][]{{0, 1}};
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    p[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    p[i][j] = 1;
                } else if (i == 0) {
                    p[i][j] = p[i][j - 1];
                } else if (j == 0) {
                    p[i][j] = p[i - 1][j];
                } else {
                    p[i][j] = p[i - 1][j] + p[i][j - 1];
                }
            }
        }
        return p[m - 1][n - 1];
    }
}
