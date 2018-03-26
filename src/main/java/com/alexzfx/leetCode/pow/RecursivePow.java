package com.alexzfx.leetCode.pow;

/**
 * Author : Alex
 * Date : 2018/1/12 10:00
 * Description :
 */
public class RecursivePow {
    /**
     * 递归解法
     * @param x 底数
     * @param n 指数
     * @return  x^n
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        //递归结束条件
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        }
        //递归过程
        if (n > 0) {
            return n % 2 == 0 ? myPow(x * x, n / 2) : myPow(x * x, (n - 1) / 2) * x;
        } else {
            return n % 2 == 0 ? 1 / myPow(x * x, -(n / 2)) : 1 / myPow(x * x, -(n + 1) / 2) / x;
        }
    }
}
