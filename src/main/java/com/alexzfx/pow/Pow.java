package com.alexzfx.pow;

/**
 * Author : Alex
 * Date : 2018/1/5 22:07
 * Description :Implement pow(x, n).
 */
public class Pow {

    public static void main(String[] args) {
        System.out.println(-3 / 2);
    }

    //    循环解法
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double result = 1.0;
        while (n != 0) {
            //如果n是个偶数的话直接向下进行直到最后n为1，是奇数的话因为除法会向下取整导致少乘一个，故在这多乘一个
            if ((n & 1) == 1) {
                if (n < 0) { //n为负数时为除，负责为乘
                    result /= x;
                } else {
                    result *= x;
                }
            }
            x *= x;
            n /= 2;//除法默认向下取整
        }
        return result;
    }

    //递归解法，自己正负数判断的处理不好
//    public double myPow(double x, int n) {
//        if (x == 0) {
//            return 0;
//        }
//        //递归结束条件
//        if (n == 1) {
//            return x;
//        } else if (n == 0) {
//            return 1;
//        }
//        //递归过程
//        if (n > 0) {
//            return n % 2 == 0 ? myPow(x * x, n / 2) : myPow(x * x, (n - 1) / 2) * x;
//        } else {
//            return n % 2 == 0 ? 1 / myPow(x * x, -(n / 2)) : 1 / myPow(x * x, -(n + 1) / 2) / x;
//        }
//    }

}
