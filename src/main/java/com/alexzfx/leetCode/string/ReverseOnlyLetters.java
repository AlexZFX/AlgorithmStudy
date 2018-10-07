package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/10/7 9:31
 * Description :
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[101];
        int[] ints = new int[101];
        for (int i = 0; i < S.toCharArray().length; i++) {
            if (isChar(S.charAt(i))) {
                sb.append(S.charAt(i));
            } else {
                ++ints[i];
                chars[i] = S.charAt(i);
            }
        }
        sb = sb.reverse();
        for (int i = 0; i < 101; i++) {
            if (ints[i] != 0) {
                sb.insert(i, chars[i]);
            }
        }
        return sb.toString();
    }

    private boolean isChar(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
