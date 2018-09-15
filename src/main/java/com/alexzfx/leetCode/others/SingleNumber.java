package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/9/12 10:34
 * Description : 136. 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * <p>
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * <p>
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 */
public class SingleNumber {

//    //136
//    public int singleNumber(int[] nums) {
//        int x = 0;
//        for (int num : nums) {
//            x ^= num;
//        }
//        return x;
//    }

//    //137
//    public int singleNumber(int[] nums) {
//        return singleNumberHelper(nums, 1, 3);
//    }
//
//    /**
//     * @param nums 原数组
//     * @param x    目标数字出现次数
//     * @param y    其他数字出现次数
//     * @return 目标数字
//     */
//    public int singleNumberHelper(int[] nums, int x, int y) {
//        if (x >= y) {
//            return -1;
//        }
//        int res = 0;
//        if (y % 2 == 0 && x % 2 == 1) {
//            for (int num : nums) {
//                res ^= num;
//            }
//            return res;
//        } else {
//            for (int i = 0; i < 32; i++) {
//                int count = 0;
//                int mask = 1 << i;
//                for (int j = 0; j < nums.length; j++) {
//                    if ((nums[j] & mask) != 0) {
//                        ++count;
//                    }
//                }
//                if (count % y != 0) {
//                    res |= mask;
//                }
//            }
//            return res;
//        }
//    }

    //260 AXORB 中必有某一位为 1, 对于这一位来说，A & AXORB = 1, B & AXORB = 0,只保留这一位的1;
    public int[] singleNumber(int[] nums) {
        int AXORB = 0;
        for (int num : nums) {
            AXORB ^= num;
        }
        //保留了尾部的一个1
        int bitFlag = AXORB & (~(AXORB - 1));
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & bitFlag) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
