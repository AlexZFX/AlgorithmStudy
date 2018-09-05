package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/9/5 9:33
 * Description : 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class MySqrt {
    //牛顿法求平方根
    public int mySqrt(int x) {
        int temp;
        double a = Math.random() * x / 2;
        while (true) {
            temp = (int) a;
            a = (a + (double) x / a) / 2;
            if (temp == (int) a) {
                return temp;
            }
        }
    }
}
