package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/30 10:01
 * Description : 915. 分割数组
 */
public class PartitionDisjoint {

    public static void main(String[] args) {
        PartitionDisjoint partitionDisjoint = new PartitionDisjoint();
        System.out.println(partitionDisjoint.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
    }

    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[] min = new int[len + 2];
        int[] max = new int[len + 1];
        min[len + 1] = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            max[i] = Math.max(A[i - 1], max[i - 1]);
        }
        for (int i = len; i > 0; i--) {
            min[i] = Math.min(A[i - 1], min[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            if (max[i + 1] <= min[i + 2]) {
                return i + 1;
            }
        }
        return 0;
    }
}
