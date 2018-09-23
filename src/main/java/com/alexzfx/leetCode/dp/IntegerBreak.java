package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/22 10:24
 * Description : 343. 整数拆分
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * ①使用dp[i]表示正整数i的最大乘积，则dp[i]=max{dp[i-1]*1,dp[i-2]*2,...,dp[i-(i-1)]*(i-1)};
 * <p>
 * ②由①可知，dp[i]的状态就能转化为其他dp[1]...dp[i-1]可得，但事实并没有这么麻烦，因为这些正整数拆分最终总会拆分为2,3和少数的1.比如：
 * <p>
 * 2：1*1=1；
 * <p>
 * 3：1*2=2；
 * <p>
 * 4：2*2=4；
 * <p>
 * 5：2*3=6；
 * <p>
 * 因此调整状态转移方程为：
 * <p>
 * dp[i]=max(dp[i-2]*2,dp[i-3]*3);
 * <p>
 * --------------------
 * <p>
 * 解法二（当成数学题来做就好）：
 * <p>
 * 由均值不等式(n个数的算术平均数大于等于它们的几何平均数)：
 * <p>
 * \mathbf{A}_n =  \frac{x_1 + x_2 + \cdots + x_n}{n}    >=   \mathbf{G}_n = \sqrt[n]{x_1 \cdot x_2 \cdots x_n}
 * <p>
 * 得：当把输入的n拆分成几个相等的数时它们的积最大。
 * <p>
 * 那么问题来了，拆分成几个呢？
 * <p>
 * 为了方便使用导数，我们先假设我们可以把n拆分成实数。那么设每一个数为x,则一共有n/x个数。
 * <p>
 * 设它们的积为f(x),则f(x)=x(n/x)，那么怎么求f(x)最大值呢？求导数！
 * <p>
 * f′(x)=(n/x2)  *  x(n/x)  * (1-lnx)
 * <p>
 * 当x=e时取极大值。
 * <p>
 * 而我们题目里规定x为整数，那么我们只需要取的x越靠近e越好。那么2<e<3，而且e=2.71828...，所以取3是最好的，如果取不到3就取2。
 * <p>
 * 幂运算复杂度为O(lgn)，所以这个算法复杂度为O(lgn)。
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        //dp[i]表示 i 对应的 integerBreak
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = 1;
            dp[i] = Math.max(Math.max((i - 2) * 2, dp[i - 2] * 2), Math.max(dp[i - 3] * 3, 3 * (i - 3)));
        }
        return dp[n];
    }

//    //复杂度O(lgN)
//    public int integerBreak(int n) {
//        if (n == 2)x
//            return 1;
//        else if (n == 3)
//            return 2;
//        else if (n % 3 == 0)
//            return (int) Math.pow(3, n / 3);
//        else if (n % 3 == 1)
//            return (int) (2 * 2 * Math.pow(3, (n - 4) / 3));
//        else
//            return (int) (2 * Math.pow(3, n / 3));
//    }
}
