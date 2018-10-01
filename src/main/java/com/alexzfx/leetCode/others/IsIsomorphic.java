package com.alexzfx.leetCode.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Alex
 * Date : 2018/10/1 10:49
 * Description : 205. 同构字符串
 */
public class IsIsomorphic {
    //可以利用一个简单的char型数组来维护map，效率高很多
    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int len = chars.length;
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])) {
                sb.append(map.get(chars[i]));
            } else if (!map.containsValue(chart[i])) {
                map.put(chars[i], chart[i]);
                sb.append(chart[i]);
            } else {
                return false;
            }

        }
        return sb.toString().equals(t);
    }
}
