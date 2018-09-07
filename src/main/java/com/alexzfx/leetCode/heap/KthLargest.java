package com.alexzfx.leetCode.heap;

/**
 * Author : Alex
 * Date : 2018/9/7 14:48
 * Description : 703. 数据流中的第K大元素
 * <p>
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 */
//所用为小顶堆解法，可用优先队列(本质也为堆实现)求解
public class KthLargest {

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

        public boolean isFull() {
            return count == size;
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

    private SmallHeap heap;

    public KthLargest(int k, int[] nums) {
        heap = new SmallHeap(k);
        if (k <= nums.length) {
            for (int i = 0; i < k; i++) {
                heap.insert(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > heap.getMin()) {
                    heap.removeAndSet(nums[i]);
                }
            }
        } else {
            for (int num : nums) {
                heap.insert(num);
            }
        }
    }

    public int add(int val) {
        if (!heap.isFull()) {
            heap.insert(val);
        } else if (val > heap.getMin()) {
            heap.removeAndSet(val);
        }
        return heap.getMin();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));
    }
}
