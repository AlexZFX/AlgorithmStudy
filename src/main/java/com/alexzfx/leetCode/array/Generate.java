package com.alexzfx.leetCode.array;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/14 15:17
 * Description : 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> lists = new ArrayList<>(numRows);
        List<Integer> list1 = Lists.newArrayList(1);
        lists.add(list1);
        List<Integer> tempList;
        // n-1 次 ，应该有 i+1个数字
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            list.add(1);
            tempList = lists.get(i - 1);
            // i - 1次
            for (int j = 1; j < i; j++) {
                list.add(tempList.get(j - 1) + tempList.get(j));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}
