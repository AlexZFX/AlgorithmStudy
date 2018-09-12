package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/12 11:34
 * Description : 287. 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1, 2, 3, 4, 5, 3}));
    }

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int l = 1, r = len - 1; // n
        int mid = (l + r) >> 1, count = 0;
        while (l < r) {
            for (int num : nums) {
                if (num <= mid) {
                    ++count;
                }
            }
            if (count <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
            count = 0;
            mid = (l + r) >> 1;
        }
        return mid;
    }

}
