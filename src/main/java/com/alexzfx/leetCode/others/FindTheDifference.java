package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/9/12 11:16
 * Description : 389. 找不同
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 */
public class FindTheDifference {

    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();
        System.out.println(findTheDifference.findTheDifference("abcd", "abcde"));
    }

    public char findTheDifference(String s, String t) {
        char x = 0;
        for (char c : s.toCharArray()) {
            x ^= c;
        }
        for (char c : t.toCharArray()) {
            x ^= c;
        }
        return x;
    }
}
