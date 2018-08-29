package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/8/29 9:12
 * Description : 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int n = removeDuplicates.removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            //按序遍历，遇到相同的就跳过，不同的复制到前面。
            if (nums[i] != nums[index]) {
                ++index;
                nums[index] = nums[i];
            }
        }
        return ++index;
    }

//    public int removeDuplicates(int[] nums) {
//        if (nums == null) {
//            return 0;
//        }
//        int len = nums.length;
//        int l = 0, r = len - 1;
//        while (l < r) {
//            while (l < r && nums[r] == nums[r - 1]) {
//                --r;
//                --len;
//            }
//            if (nums[l] == nums[l + 1] && l + 1 != len) {
//                nums[l] = nums[r];
//                ++l;
//                --len;
//                --r;
//            } else {
//                ++l;
//            }
//        }
//        Arrays.sort(nums, 0, len);
//        return len;
//    }
}
