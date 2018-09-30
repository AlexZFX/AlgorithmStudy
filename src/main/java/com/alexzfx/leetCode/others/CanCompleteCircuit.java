package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/9/30 15:44
 * Description : 134. 加油站
 */
public class CanCompleteCircuit {

    //只要能走完，则总的gas >= cost
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;
        int sum = 0, total = 0;
        for (int i = 0; i < len; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else {
                sum += gas[i] - cost[i];
            }

        }
        return total >= 0 ? start : -1;
    }

//    // O(n2)
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int len = gas.length;
//        int stamp, off;
//        for (int i = 0; i < len; i++) {
//            off = i;
//            stamp = 0;
//            while (true) {
//                stamp += gas[off];
//                stamp -= cost[off];
//                ++off;
//                if (stamp < 0) {
//                    break;
//                }
//                if (off == len)
//                    off = 0;
//                if (off == i) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
}
