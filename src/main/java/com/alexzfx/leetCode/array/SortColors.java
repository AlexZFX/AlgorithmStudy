package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/10 20:08
 * Description : 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1, 1, 0, 2};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
    }

//    //一次遍历，但常数级操作更多
//    public void sortColors(int[] nums) {
//        //分别表示当前处理好的0，1，2的最后一位
//        int i = -1, j = -1, k = -1, len = nums.length;
//        for (int m = 0; m < len; m++) {
//            if (nums[m] == 0) {
//                nums[++k] = 2;
//                nums[++j] = 1;
//                nums[++i] = 0;
//            } else if (nums[m] == 1) {
//                nums[++k] = 2;
//                nums[++j] = 1;
//            } else {
//                nums[++k] = 2;
//            }
//        }
//    }


    //两遍扫描
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (nums[l] == 0 && l < r) {
                ++l;
            }
            while (nums[r] != 0 && r > l) {
                --r;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        r = nums.length - 1;
        while (l < r) {
            while (nums[l] == 1 && l < r) {
                ++l;
            }
            while (nums[r] != 1 && l < r) {
                --r;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
