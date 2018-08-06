package com.alexzfx.leetCode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/8/6 20:54
 * Description : 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 思路 ：递归添加
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        add(list, n, n, "");
        return list;
    }

    private void add(List<String> list, int left, int right, String path) {
        if (left == 0 && right == 0) {
            list.add(path);
        }
        //只要l > 0 就可以添加 (
        if (left > 0) {
            add(list, left - 1, right, path + "(");
        }
        //只要 l < r 就可以添加 )
        if (left < right) {
            add(list, left, right - 1, path + ")");
        }
    }

}
