package com.alexzfx.leetCode.heap;

/**
 * Author : Alex
 * Date : 2018/9/7 13:24
 * Description : 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = new int[]{-1, 2, 0};
        System.out.println(findKthLargest.findKthLargest(nums, 3));
    }

    //小顶堆
    private class SmallHeap {
        int count;
        int size;
        int[] array;

        SmallHeap(int size) {
            this.array = new int[size + 1];
            this.size = size;
            this.count = 0;
        }

        public void insert(int val) {
            if (count < size) {
                array[++count] = val;
                shiftUp(count);
            }
        }

        public int getMin() {
            return array[1];
        }

        public void removeAndSet(int val) {
            array[1] = val;
            shiftDown(1);
        }

        //把第off个元素做shiftUp操作
        private void shiftUp(int i) {
            while ((i >> 1) > 0) {
                if (array[i] < array[i >> 1]) {
                    swap(i, i >> 1);
                    i = i >> 1;
                } else {
                    break;
                }
            }
        }

        private void shiftDown(int i) {
            while ((i << 1) <= count) {
                int j = i << 1; // i j交换位置
                //如果存在右孩子且右孩子小于左孩子，则和右孩子比较
                if (j + 1 <= count && array[j] > array[j + 1]) {
                    ++j;
                }
                if (array[i] > array[j]) {
                    swap(i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        SmallHeap heap = new SmallHeap(k);
        for (int i = 0; i < k; i++) {
            heap.insert(nums[i]);
        }
        for (int i = k; i < len; i++) {
            if (nums[i] > heap.getMin()) {
                heap.removeAndSet(nums[i]);
            }
        }
        return heap.getMin();
    }
}
