package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/9/5 8:40
 * Description : 58. 最后一个单词的长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
//        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
        char[] chars = s.toCharArray();
        int end = chars.length - 1;
        int count = 0;
        while (end >= 0 && chars[end] == ' ') {
            --end;
        }
        while (end >= 0 && chars[end] != ' ') {
            --end;
            ++count;
        }
        return count;
    }
}
