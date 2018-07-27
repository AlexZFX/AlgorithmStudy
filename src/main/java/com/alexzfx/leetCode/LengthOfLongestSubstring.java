package com.alexzfx.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Alex
 * Date : 2018/5/4 20:52
 * Description : 3 fin
 * 找出不含重复字符的最长子串长度
 * 思路: 用一个map保存字符信息，map中不存在相应字符，length++；存在相应字符，检测是否在目前保存的子串中，
 * 不在则忽略，在则改动
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int l = lengthOfLongestSubstring("abcabccc");
        System.out.println(l);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        //key为字符，value为上个该字符的位置
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0;
        int now = 0;
        int temp;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                //temp值表示当前遇到相同字符和上个该字符的距离
                temp = i - map.get(chars[i]);
                //要是temp大于now length，则说明该字符已无影响，++now length
                now = temp > now ? ++now : temp;
            } else {
                //不存在时直接++now的length
                now++;
            }
            //更新最大length
            length = now > length ? now : length;
            map.put(chars[i], i);
        }
        return length;
    }

}
