package com.alexzfx.leetCode.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Alex
 * Date : 2017/12/29 14:55
 * Description :
 * Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    /**
     * 注意要求返回的是下标，不是数字本身,
     * 思路：为将已检查过的元素的 数值和下标作为key和value放入map
     *      之后进行检测是否存在满足要求的数字，存在则将其对应的value和当前下标一起返回。
     *
     * @param array  the given array
     * @param target target number
     * @return the result array
     */
    public int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{map.get(target - array[i]), i};
            }
            map.put(array[i], i);
        }
        return new int[2];
    }
}
