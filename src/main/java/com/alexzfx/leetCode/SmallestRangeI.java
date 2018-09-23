package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/9/23 9:30
 * Description : 908. 最小差值 I
 */
public class SmallestRangeI {

    public static void main(String[] args) {
        SmallestRangeI smallestRangeI = new SmallestRangeI();
        System.out.println(smallestRangeI.smallestRangeI(new int[]{0, 10}, 2));
    }

    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int aA : A) {
            min = min < aA ? min : aA;
            max = max > aA ? max : aA;
        }
        if (max - K > min + K) {
            return max - min - K * 2;
        } else {
            return 0;
        }
    }
}
