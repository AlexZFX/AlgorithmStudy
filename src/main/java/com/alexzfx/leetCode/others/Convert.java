package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/7/26 15:53
 * Description : 6
 * Z字形变换
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int len = chars.length;
        int temp;
        boolean flag;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                temp = i;
                while (temp < len) {
                    stringBuffer.append(chars[temp]);
                    // numRows == 1 时会导致死循环
                    temp += 2 * numRows - 2;
                }
            } else {
                flag = true;
                temp = i;
                while (temp < len) {
                    stringBuffer.append(chars[temp]);
                    temp += flag ? 2 * (numRows - i) - 2 : 2 * i;
                    flag = !flag;
                }
            }
        }
        return stringBuffer.toString();
    }
}
