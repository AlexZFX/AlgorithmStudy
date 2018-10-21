package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/10/21 9:35
 * Description : 926. 将字符串翻转到单调递增
 * <p>
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * <p>
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 * <p>
 * 返回使 S 单调递增的最小翻转次数。
 */
public class MinFlipsMonoIncr {

    public static void main(String[] args) {
        MinFlipsMonoIncr minFlipsMonoIncr = new MinFlipsMonoIncr();
        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("00110"));
    }

    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int len = chars.length;
        int i = 0, count0 = 0, count1 = 0;
        while (i < len && chars[i] == '0') {
            ++i;
        }
        int res = 0;
        while (i < len) {
            if (chars[i] == '0') {
                ++count0;
                if (count0 > count1) {
                    res += count1;
                    count1 = 0;
                    count0 = 0;
                }
            } else {
                ++count1;
            }
            ++i;
        }
        return res + Math.min(count0, count1);
    }
}
