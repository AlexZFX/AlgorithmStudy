package com.alexzfx.leetCode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/12 15:27
 * Description : 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */
public class MinimumTotal {

    //O(n)空间复杂度
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size(), size;
        int[] p = new int[len + 1]; //用下标为1~n的位置来存储
        for (List<Integer> list : triangle) {
            size = list.size();
            p[size] = p[size - 1] + list.get(--size); // 当前三角形最后一个，由 自己+左上方 得出
            while (size > 1) {
                p[size] = Math.min(p[size], p[size - 1]) + list.get(size - 1); // 自己 + max(左上|右上)
                --size;
            }
            p[size] = p[size] + list.get(0); // 最后一行第一个由 自己 + 右上 得出
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (p[i] < min) {
                min = p[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(minimumTotal.minimumTotal(lists));
    }
}
