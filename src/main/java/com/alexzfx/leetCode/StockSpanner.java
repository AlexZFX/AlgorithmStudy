package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/9/9 10:14
 * Description : 901. 股票价格跨度
 * <p>
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * <p>
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 */
public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

    private int[] nums;
    private int[] counts;
    private int size;

    public StockSpanner() {
        nums = new int[10000];
        counts = new int[10000];
        counts[0] = 1;
        size = 0;
    }

    public int next(int price) {
        nums[size] = price;
        int count = 1;
        for (int i = size; i > 0; ) {
            if (price >= nums[i - 1]) {
                count += counts[i - 1];
                i -= counts[i - 1];
            } else {
                break;
            }
        }
        counts[size] = count;
        ++size;
        return count;
    }
}
