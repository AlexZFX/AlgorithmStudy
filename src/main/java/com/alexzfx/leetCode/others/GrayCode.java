package com.alexzfx.leetCode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/8 9:35
 * Description : 89. 格雷编码
 * <p>
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        grayCode.grayCode(5);
    }

    //我的解法
//    public List<Integer> grayCode(int n) {
//        List<Integer> list = new ArrayList<Integer>();
//        if (n < 0) {
//            return list;
//        } else if (n == 0) {
//            list.add(0);
//            return list;
//        } else if (n == 1) {
//            list.add(0);
//            list.add(1);
//            return list;
//        } else {
//            list = grayCode(n - 1);
//            int num = (int) Math.pow(2, n - 1);
//            int i = num - 1;
//            while (i >= 0) {
//                list.add(list.get(i--) + num);
//            }
//            return list;
//        }
//    }

    //网上最佳解法
    public List<Integer> grayCode(int n) {
        int N = 1 << n;//最后list的总长度
        List<Integer> list = new ArrayList<Integer>(N);
        for (int i = 0; i < N; i++) {
            //和自己的二分之一按位 异或
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}
