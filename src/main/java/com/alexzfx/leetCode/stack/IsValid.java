package com.alexzfx.leetCode.stack;

import java.util.Stack;

/**
 * Author : Alex
 * Date : 2018/7/31 9:27
 * Description : 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        char tempChar;
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                    stack.push(chars[i]);
                } else {
                    tempChar = stack.pop();
                    if (!((tempChar == '(' && chars[i] == ')') || (tempChar == '[' && chars[i] == ']') || (tempChar == '{' && chars[i] == '}'))) {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
