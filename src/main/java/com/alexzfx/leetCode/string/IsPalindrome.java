package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/9/13 13:23
 * Description : 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && isInVaildChar(chars[l])) {
                ++l;
            }
            while (l < r && isInVaildChar(chars[r])) {
                --r;
            }
            if (!(chars[l] == chars[r] || ((Math.abs(chars[l] - chars[r]) == 32) && chars[l] >= 65 && chars[r] >= 65))) {
                return false;
            } else {
                ++l;
                --r;
            }
        }
        return true;
    }

    private boolean isInVaildChar(char c) {
        return (c <= 47 || c >= 58) && (c <= 64 || c >= 91) && (c <= 96 || c >= 123);
    }
}
