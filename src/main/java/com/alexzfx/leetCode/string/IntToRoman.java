package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/7/24 19:08
 * Description : 12
 * 整数转罗马数字
 */
public class IntToRoman {

    public String intToRoman(int num) {
        String[] m = new String[]{"", "M", "MM", "MMM"};
        String[] c = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return m[num / 1000] + c[num % 1000 / 100] + x[num % 100 / 10] + i[num % 10];
    }

}
