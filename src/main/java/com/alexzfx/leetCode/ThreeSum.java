package com.alexzfx.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/7/22 15:06
 * Description : 15 three sum ，3指针移动
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
 * ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int left = 0, right = 0;
        int target = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            target = -nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    --right;
                    continue;
                } else if (sum < target) {
                    ++left;
                    continue;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    //将此时left对应相等的数字全部跳过
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    //将此时right对应相等的数字全部跳过
                    while (right - 1 < left && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    //跳过之后再++
                    ++left;
                    //跳过之后再--
                    --right;
                }
            }
            //将与当前数字相等的数据跳过
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return lists;
    }

//time Out
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        boolean flag = false;
//        Arrays.sort(nums);
//        List<List<Integer>> lists2;
//        List<Integer> numList = new ArrayList<Integer>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//            if (numList.contains(nums[i])) {
//                continue;
//            }
//            numList.add(nums[i]);
//            lists2 = twoSum(nums, i+1, nums[i]);
//            for (List<Integer> list : lists2) {
//                for (List<Integer> integers : lists) {
//                    if (isEqual(integers, list)) {
//                        flag = true;
//                    }
//                }
//                if (!flag) {
//                    lists.add(list);
//                }
//                flag = false;
//            }
//
//        }
//        return lists;
//    }
//
//    boolean isEqual(List<Integer> list1, List<Integer> list2) {
//        return list1.containsAll(list2) && list2.containsAll(list1);
//    }
//
//    private List<List<Integer>> twoSum(int[] array, int start, int target) {
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int temp = -target;
//        for (int i = start; i < array.length; i++) {
//            if (map.containsKey(temp - array[i])) {
//                ArrayList<Integer> list = new ArrayList<Integer>(3);
//                list.add(target);
//                list.add(temp - array[i]);
//                list.add(array[i]);
//                lists.add(list);
//            }
//            map.put(array[i], i);
//        }
//        return lists;
//    }
}
