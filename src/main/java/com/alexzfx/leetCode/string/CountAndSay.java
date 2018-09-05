package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/9/4 17:08
 * Description : 38. 报数
 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                ++count;
            } else {
                sb.append(count).append(chars[i]);
                count = 1;
            }
        }
        sb.append(count).append(chars[chars.length - 1]);
        return sb.toString();
    }
}
