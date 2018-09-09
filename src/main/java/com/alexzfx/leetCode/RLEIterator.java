package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/9/9 9:49
 * Description : 900. RLE 迭代器
 * <p>
 * 编写一个遍历游程编码序列的迭代器。
 * <p>
 * 迭代器由 RLEIterator(int[] A) 初始化，其中 A 是某个序列的游程编码。更具体地，对于所有偶数 i，A[i] 告诉我们在序列中重复非负整数值 A[i + 1] 的次数。
 * <p>
 * 迭代器支持一个函数：next(int n)，它耗尽接下来的  n 个元素（n >= 1）并返回以这种方式耗去的最后一个元素。如果没有剩余的元素可供耗尽，则  next 返回 -1 。
 * <p>
 * 例如，我们以 A = [3,8,0,9,2,5] 开始，这是序列 [8,8,8,5,5] 的游程编码。这是因为该序列可以读作 “三个零，零个九，两个五”。
 */
public class RLEIterator {

    public static void main(String[] args) {
        int[] A = new int[]{811, 903, 310, 730, 899, 684, 472, 100, 434, 611};
        RLEIterator iterator = new RLEIterator(A);
        System.out.println(iterator.next(358));
        System.out.println(iterator.next(345));
        System.out.println(iterator.next(154));
        System.out.println(iterator.next(265));
        System.out.println(iterator.next(73));
        System.out.println(iterator.next(220));
        System.out.println(iterator.next(138));
        System.out.println(iterator.next(4));
        System.out.println(iterator.next(170));
        System.out.println(iterator.next(88));
    }

    private int[] A;

    public RLEIterator(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        int len = A.length;
        int temp;
        for (int i = 0; i < len; i += 2) {
            while (A[i] > 0) {
                temp = A[i] - n;
                if (temp >= 0) {
                    A[i] = temp;
                    return A[i + 1];
                } else {
                    n -= A[i];
                    A[i] = 0;
                }
            }
        }
        return -1;
    }
}
