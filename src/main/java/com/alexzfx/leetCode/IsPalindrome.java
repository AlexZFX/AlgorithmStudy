package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/7/24 18:34
 * Description : 9 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(-101));
    }

    public boolean isPalindrome(int x) {
//        StringBuilder sb = new StringBuilder(String.valueOf(x));
//        String s = sb.toString();
//        String reverse = sb.reverse().toString();
//        if (s.equals(reverse))
//            return true;
//        return false;
        //if判断可有可无，
        if (x < 0) {
            return false;
        }
        int y = 0;
        int z = x;
        while (z > 0) {
            y = y * 10 + z % 10;
            z /= 10;
        }
        return x == y;
    }
}
