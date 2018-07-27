package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/5/5 16:46
 * Description : 28 fin
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack
 * 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class StrStr {

    public int strStr(String hayStack, String needle) {
        if (needle == null) {
            return 0;
        }
        return hayStack.indexOf(needle);
    }
}
