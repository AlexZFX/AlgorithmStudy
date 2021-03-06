package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/10/5 11:05
 * Description : 221. 最大正方形
 */
public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                {'0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1'}}));
    }

    // n2
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] res = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) res[i][j] = matrix[i][j] == '0' ? 0 : 1;
                else {
                    if (matrix[i][j] == '0') {
                        res[i][j] = 0;
                    } else {
                        //只有自己左上方3个都是 1 的时候 ，res[i][j] 才 大于1
                        res[i][j] = Math.min(res[i - 1][j - 1], Math.min(res[i][j - 1], res[i - 1][j])) + 1;
                    }
                }
                max = Math.max(res[i][j], max);
            }
        }
        return max * max;
    }

//    //n3
//    public int maximalSquare(char[][] matrix) {
//        int x = matrix.length;
//        if (x < 1) {
//            return 0;
//        }
//        int y = matrix[0].length;
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                matrix[i][j] -= 48;
//            }
//        }
//        if (y < 1) {
//            return 0;
//        } else if (y == 1) {
//            return matrix[0][0];
//        } else if (x == 1) {
//            for (int i = 0; i < y; i++) {
//                if (matrix[0][i] == 1) {
//                    return 1;
//                }
//            }
//            return 0;
//        }
//        //dp i j 表示以 i j为右下角的最大正方形
//        int[][] dp = new int[x][y];
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                dp[i][j] = matrix[i][j];
//            }
//        }
//        int max = Math.max(matrix[0][0], Math.max(matrix[1][0], matrix[0][1])), temp = 0;
//        for (int i = 1; i < x; i++) {
//            for (int j = 1; j < y; j++) {
//                if (matrix[i][j] == 1) {
//                    temp = dp[i - 1][j - 1];
//                    for (int k = 1; k <= temp; k++) {
//                        if (matrix[i][j - k] == 1 && matrix[i - k][j] == 1) {
//                            ++dp[i][j];
//                        } else {
//                            break;
//                        }
//                    }
//                }
//                max = Math.max(max, dp[i][j]);
//            }
//        }
//        return max * max;
//    }
}
