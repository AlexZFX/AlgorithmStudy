package com.alexzfx.leetCode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author : Alex
 * Date : 2018/9/30 10:19
 * Description : 916. 单词子集
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        Map<Character, Integer> map = new HashMap<>();
        for (String iB : B) {
            for (char c : iB.toCharArray()) {
                if (map.containsKey(c)) {
                    if (map.get(c) < getCharNum(c, iB)) {
                        map.put(c, getCharNum(c, iB));
                    }
                } else {
                    map.put(c, 1);
                }
            }
        }

        List<String> res = new ArrayList<>();
        boolean isSub = true;
        for (String aA : A) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (!(getCharNum(entry.getKey(), aA) >= entry.getValue())) {
                    isSub = false;
                    break;
                }
            }
            if (isSub) {
                res.add(aA);
            } else {
                isSub = true;
            }
        }
        return res;
    }

    private int getCharNum(char c, String s) {
        int res = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 == c) {
                ++res;
            }
        }
        return res;
    }
}
