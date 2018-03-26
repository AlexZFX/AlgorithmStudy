package com.alexzfx.leetCode.hamingDistance;

/**
 * Author : Alex
 * Date : 2018/1/5 21:28
 * Description :The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.Given two integers x and y, calculate the Hamming distance.
 */
public class HamingDistance {

    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int dist = 0;
        char[] s = Integer.toBinaryString(a).toCharArray();
        for (char c : s) {
            if (c == '1') {
                ++dist;
            }
        }
        return dist;
    }
}

