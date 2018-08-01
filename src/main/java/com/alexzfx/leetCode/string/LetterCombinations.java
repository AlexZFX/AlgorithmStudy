package com.alexzfx.leetCode.string;

import java.util.*;

/**
 * Author : Alex
 * Date : 2018/8/1 19:00
 * Description : 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    private static Map<Character, char[]> map = new HashMap<Character, char[]>();

    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23").toString());
    }

    //TODO 错误结果
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        int len = 1;
        char[] chars = digits.toCharArray();
        for (char aChar : chars) {
            len *= map.get(aChar).length;
        }
        List<String> res = new ArrayList<String>(len);
        StringBuffer[] stringBuffers = new StringBuffer[len];
        for (int i = 0; i < stringBuffers.length; i++) {
            stringBuffers[i] = new StringBuffer();
        }
        char[] numChars;
        int charLen;
        for (char aChar : chars) {
            numChars = map.get(aChar);
            charLen = numChars.length;
            for (int i = 0; i < stringBuffers.length; i++) {
                stringBuffers[i].append(numChars[i % charLen]);
            }
        }
        for (StringBuffer stringBuffer : stringBuffers) {
            res.add(stringBuffer.toString());
        }
        return res;
    }
}
