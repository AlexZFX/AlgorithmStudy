package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/9/14 13:35
 * Description : 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 中要注意输入的数是无符号数，在JAVA中没有无符号数，都是有符号的，
 * 而且是32位表示int类型数，范围为：-2147483648~2147483647（-2^31~2^31-1）。
 * 题目中是无符号数，使用32位表示，所以可以表示的范围为0~2^32-1，
 * 因此输入的数字会超过Java中int的范围，那么，为了保证对这个无符号数进行正确的二进制处理，
 * 不能使用常规的十进制转换二进制算法，而是要使用按位运算方法，
 * 或者使用Integer类的toBinaryString(int i)方法，
 * 把整型参数以二进制无符号整数形式返回一个字符串对象再对这个字符串对象进行处理。
 */
public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(Integer.MIN_VALUE));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
