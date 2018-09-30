package com.alexzfx.leetCode;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/9/30 9:30
 * Description : 914. 卡牌分组
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class HasGroupsSizeX {

    public static void main(String[] args) {
        HasGroupsSizeX hasGroupsSizeX = new HasGroupsSizeX();
        System.out.println(hasGroupsSizeX.hasGroupsSizeX(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4}));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        Arrays.sort(deck);
        int X = 1;
        int temp = 1;
        while (temp < deck.length && deck[temp] == deck[temp - 1]) {
            ++X;
            ++temp;
        }
        temp = 1;
        for (int i = X + 1; i < deck.length; i++) {
            while (i < deck.length && deck[i] == deck[i - 1]) {
                ++temp;
                ++i;
            }
            if (temp == 1) {
                return false;
            } else if (temp == X || (temp > X && temp % X == 0)) {
                temp = 1;
            } else if (temp < X && X % temp == 0) {
                X = temp;
                temp = 1;
            } else {
                int div = gcd(X, temp);
                if (div != 1) {
                    X = div;
                    temp = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // 循环法求最大公约数
    private int gcd(int a, int b) {
        while (b > 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        return a;
    }

    //更优解
//    public boolean hasGroupsSizeX(int[] deck) {
//        int[] f = new int[10001];
//    //数据范围说明
//        for(int d : deck){
//            f[d]++;
//        }
//        int g = 0;
//      //都取最大公约数
//        for(int v : f){
//            g = gcd(g, v);
//        }
//        return g != 1;
//    }
}
