package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/10/21 9:31
 * Description : 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        int i = 0, j = 0;
        int len1 = names.length, len2 = typeds.length;
        while (j < len2) {
            if (names[i] == typeds[j]) {
                ++i;
                ++j;
            } else {
                ++j;
            }

            if (i == len1) {
                return true;
            }
        }
        return false;
    }
}
