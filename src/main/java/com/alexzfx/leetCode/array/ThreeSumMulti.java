package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/10/14 9:41
 * Description : 923. 三数之和的多种可能
 */
public class ThreeSumMulti {

    public static void main(String[] args) {
        ThreeSumMulti sumMulti = new ThreeSumMulti();
        System.out.println(sumMulti.threeSumMulti(new int[]{35, 29, 93, 59, 16, 53, 90, 88, 2, 28, 40, 83, 60, 92, 22, 18, 70, 42, 50, 73, 10, 23, 17, 3, 48, 51, 29, 16, 42, 33, 51, 34, 13, 38, 54, 59, 19, 92, 60, 81, 69, 90, 80, 1, 12, 72, 79, 1, 67, 63, 13, 2, 61, 65, 16, 19, 20, 52, 19, 68, 11, 90, 9, 77, 29, 91, 78, 42, 66, 41, 67, 97, 79, 0, 49, 6, 84, 37, 59, 93, 23, 40, 16, 0, 46, 74, 62, 97, 96, 99, 53, 84, 99, 14, 82, 21, 24, 43, 7, 11, 41, 96, 19, 8, 8, 45, 60, 57, 16, 26, 54, 64, 83, 95, 29, 42, 43, 27, 14, 4, 52, 76, 41, 20, 7, 27, 3, 39, 26, 49, 18, 31, 51, 63, 88, 94, 46, 27, 40, 16, 46, 29, 93, 18, 39, 35, 100, 4, 29, 81, 9, 37, 21, 9, 53, 30, 58, 78, 41, 77, 30, 50, 16, 84, 59, 53, 40, 90, 4, 85, 53, 89, 62, 27, 1, 2, 31, 79, 47, 76, 9, 82, 86, 76, 5, 55, 100, 77, 64, 35, 70, 100, 59, 47, 35, 70, 59, 93, 59, 98, 14, 31, 30, 12, 26, 13, 7, 16, 3, 76, 23, 46, 39, 81, 25, 5, 70, 73, 7, 35, 71, 18, 66, 60, 86, 63, 97, 32, 14, 35, 68, 69, 31, 52, 83, 34, 100, 40, 44, 7, 28, 76, 38, 90, 36, 34, 10, 99, 47, 49, 63, 74, 5, 53, 11, 99, 33, 46, 78, 36, 51, 26, 43, 83, 9, 68, 31, 48, 71, 53, 64, 64, 43, 62, 77, 59, 100, 84, 15, 23, 95, 5, 6, 7, 23, 20, 84, 60, 75, 25, 63, 54, 94, 83, 52, 16, 26, 48, 40, 75}, 138));
    }

    public int threeSumMulti(int[] A, int target) {
        int[] numNums = new int[101];
        //统计每个数字有多少个
        for (int a : A) {
            ++numNums[a];
        }
        long sum = 0;
        // 每个数字只出现一次时
        for (int i = 0; i < 101; i++) {
            sum += getThreeSum(numNums, i, target - i);
            sum %= 100000007;
        }
        //有数字出现2次时
        for (int i = 0; i < 101; i++) {
            if (numNums[i] > 1) {
                for (int j = 0; j < 101; j++) {
                    if (i == j) {
                    } else if (i * 2 + j == target) {
                        sum += numNums[i] * (numNums[i] - 1) / 2 * numNums[j];
                        sum %= 1000000007;
                    }
                }
            }
        }

        for (int i = 0; i < 101; i++) {
            if (numNums[i] > 2 && 3 * i == target) {
                sum += numNums[i] * (numNums[i] - 1) * (numNums[i] - 2) / 6;
                break;
            }
        }
        return (int) (sum % 1000000007);
    }

    private int getThreeSum(int[] numNums, int mid, int target) {
        int l = mid - 1, r = mid + 1, sum = 0;
        while (l > -1 && r < 101) {
            while (l > -1 && numNums[l] == 0) {
                --l;
            }
            while (r < 101 && numNums[r] == 0) {
                ++r;
            }
            if (l > -1 && r < 101 && l + r == target) {
                sum += numNums[l] * numNums[r] * numNums[mid];
                --l;
                ++r;
            } else if (l + r < target) {
                ++r;
            } else {
                --l;
            }
        }
        return sum;
    }

}
