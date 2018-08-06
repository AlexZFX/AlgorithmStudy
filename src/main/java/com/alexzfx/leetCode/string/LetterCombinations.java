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

    private static Map<Character, char[]> characterMap = new HashMap<Character, char[]>();

    static {
        characterMap.put('2', new char[]{'a', 'b', 'c'});
        characterMap.put('3', new char[]{'d', 'e', 'f'});
        characterMap.put('4', new char[]{'g', 'h', 'i'});
        characterMap.put('5', new char[]{'j', 'k', 'l'});
        characterMap.put('6', new char[]{'m', 'n', 'o'});
        characterMap.put('7', new char[]{'p', 'q', 'r', 's'});
        characterMap.put('8', new char[]{'t', 'u', 'v'});
        characterMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("234").toString());
    }
//    //队列解法
//    public List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0) {
//            return Collections.emptyList();
//        }
//        int len = 1;
//        char[] chars = digits.toCharArray();
//        LinkedList<String> res = new LinkedList<String>();
//        char[] tempChars;
//        res.addLast("");
//        for (int i = 0; i < chars.length; i++) {
//            tempChars = characterMap.get(chars[i]);
//            String s = res.getFirst();
//            len = s.length();
//            while (s.length() == len) {
//                s = res.removeFirst();
//                for (char tempChar : tempChars) {
//                    res.addLast(s + tempChar);
//                }
//                s = res.getFirst();
//            }
//        }
//        return res;
//    }

    //计算改变添加字母位置解法。
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        int len = 1;
        char[] chars = digits.toCharArray();
        for (char aChar : chars) {
            len *= characterMap.get(aChar).length;
        }
        List<String> res = new ArrayList<String>(len);
        StringBuffer[] stringBuffers = new StringBuffer[len];
        for (int i = 0; i < stringBuffers.length; i++) {
            stringBuffers[i] = new StringBuffer();
        }
        char[] numChars;
        int charLen;
        for (char aChar : chars) {
            numChars = characterMap.get(aChar);
            charLen = numChars.length;
            //改变 间隔 数目，间隔n个改变添加的字母。
            int templen = len / charLen;
            for (int i = 0; i < stringBuffers.length; i++) {
                stringBuffers[i].append(numChars[(i / templen) % charLen]);
            }
            len = templen;
        }
        for (StringBuffer stringBuffer : stringBuffers) {
            res.add(stringBuffer.toString());
        }
        return res;
    }
}
