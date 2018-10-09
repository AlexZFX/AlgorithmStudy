package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/10/8 12:58
 * Description :
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }
}
