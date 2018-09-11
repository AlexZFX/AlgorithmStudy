package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/9/9 10:38
 * Description : 902. 最大为 N 的数字组合
 * <p>
 * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
 * <p>
 * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
 * <p>
 * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
 */
public class AtMostNGivenDigitSet {

    public static void main(String[] args) {
        String[] D = new String[]{"3", "4", "6", "7", "9"};
        AtMostNGivenDigitSet atMostNGivenDigitSet = new AtMostNGivenDigitSet();
        System.out.println(atMostNGivenDigitSet.atMostNGivenDigitSet(D, 4170));
    }

    public int atMostNGivenDigitSet(String[] D, int N) {
        int count = 0;
        String s = String.valueOf(N);
        int len = D.length;
        int n = s.length();
        int[] tempCount = new int[n];
        int start = 1;
        //位数小于N时的数字个数
        for (int i = 1; i < n; i++) {
            start = start * len;
            tempCount[i - 1] = start;
            count += start;
        }
        // 同位数可添加的数字个数
        boolean equal = false;
        // 不相等的时候，可以
        for (int i = 0; i < s.toCharArray().length; i++) {
            equal = false;
            for (int j = 0; j < D.length; j++) {
                if (D[j].charAt(0) < s.charAt(i)) {
                    if (n - 2 - i >= 0) {
                        count += tempCount[n - 2 - i];
                    } else {
                        count += 1;
                    }
                    //数组本身是有序的，如果相等则必然已经处理完的小于的情况
                } else if (D[j].charAt(0) == s.charAt(i)) {
                    //如果是最后一位
                    if (i == n - 1) {
                        count += 1;
                    }
                    equal = true;
                }
            }
            if (!equal) {
                return count;
            }
        }
        return count;
    }
}
