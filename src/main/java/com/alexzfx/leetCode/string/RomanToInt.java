package com.alexzfx.leetCode.string;

import java.util.HashMap;

/**
 * Author : Alex
 * Date : 2018/8/1 18:24
 * Description : 13.罗马数字转整数
 */
public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        //从后向前添加，右边的+，左边的-,左边待减的最多只有一位
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }

}
