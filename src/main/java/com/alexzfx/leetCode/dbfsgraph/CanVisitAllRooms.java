package com.alexzfx.leetCode.dbfsgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/3 12:12
 * Description : 841. 钥匙和房间
 */
public class CanVisitAllRooms {

    public static void main(String[] args) {
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        List<Integer> list3 = new ArrayList<>();
        rooms.add(list);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] can = new boolean[rooms.size()];
        if (can.length < 1) {
            return true;
        }
        can[0] = true;
        dfs(can, rooms, 0);
        for (boolean b : can) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(boolean[] can, List<List<Integer>> rooms, int now) {
        for (Integer room : rooms.get(now)) {
            if (!can[room]) {
                can[room] = true;
                dfs(can, rooms, room);
            }
        }
    }
}
