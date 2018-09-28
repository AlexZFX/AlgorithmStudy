package com.alexzfx.leetCode.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Alex
 * Date : 2018/9/28 16:54
 * Description : 771. 宝石与石头
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Object> map = new HashMap<>();
        for (char c : J.toCharArray()) {
            map.put(c, null);
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) {
                ++res;
            }
        }
        return res;
    }
}
