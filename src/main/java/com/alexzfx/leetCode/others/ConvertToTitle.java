package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/10/1 14:12
 * Description : 168. Excel表列名称
 */
public class ConvertToTitle {

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(676));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int index = n % 26;
            if (index == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                sb.append((char) (index + 64));
                n = n / 26;
            }
        }
        return sb.reverse().toString();
    }
}
