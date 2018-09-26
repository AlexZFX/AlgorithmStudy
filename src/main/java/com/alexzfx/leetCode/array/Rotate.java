package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/26 19:07
 * Description : 48. 旋转图像
 * 按照主对角线，将对称元素交换
 * 按照列，将对称列元素全部交换
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            for (int k = 0; k < len; k++) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
        }
    }

}
