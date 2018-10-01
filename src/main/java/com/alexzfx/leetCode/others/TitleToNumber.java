package com.alexzfx.leetCode.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Alex
 * Date : 2018/10/1 13:52
 * Description : 171. Excel表列序号
 */
public class TitleToNumber {
    private static Map<Character, Integer> map = new HashMap<>(26);

    static {
        for (int i = 65; i <= 90; i++) {
            map.put((char) i, i - 64);
        }
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        System.out.println(titleToNumber.titleToNumber("ZZ"));
    }

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int temp = 1;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += map.get(s.charAt(i)) * temp;
            temp *= 26;
        }
        return res;
    }
}
