package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/8 13:00
 * Description : 96. 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(4));
    }

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] p = new int[n + 1];
        p[0] = 1;
        p[1] = 1;
        p[2] = 2;
        int x;
        for (int i = 3; i <= n; i++) {
            //除根结点外节点个数
            x = i - 1;
            while (x >= 0) {
                p[i] += p[x] * p[i - 1 - x];
                --x;
            }
        }
        return p[n];
    }
}
