package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/7/23 11:23
 * Description : 7
 * 给定一个 32 位有符号整数，将整数中的数字进行反转
 */
public class Reverse {

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(-2147483648));
    }

    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int end = 0;
        if (chars[end] == '-') {
            builder.append(chars[end]);
            ++end;
        }
        for (int i = chars.length - 1; i >= end; --i) {
            builder.append(chars[i]);
        }
        long result = Long.valueOf(builder.toString());
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }
}
