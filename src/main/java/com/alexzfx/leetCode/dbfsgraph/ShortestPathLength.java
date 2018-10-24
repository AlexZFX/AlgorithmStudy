package com.alexzfx.leetCode.dbfsgraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : Alex
 * Date : 2018/10/23 10:43
 * Description : 847. 访问所有节点的最短路径
 * <p>
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
 * <p>
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 * <p>
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 */
public class ShortestPathLength {

    public int shortestPathLength(int[][] graph) {
        Queue<Node> queue = new LinkedList<>();
        int len = graph.length;
        for (int i = 0; i < len; i++) {
            queue.offer(new Node(i, 1 << i, 0));
        }
        //一定要打括号，不然运算顺序是先len-1再移位
        int flag = (1 << len) - 1; // 全 1 ，表示所有节点已访问
        //开了很大的空间来存储保证某个路径不会被重复访问
        boolean[][] visited = new boolean[len][1 << len];
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.mask == flag) {
                return node.step;
            }
            int newMark;
            for (int i : graph[node.curr]) {
                newMark = node.mask | (1 << i);
                if (!visited[i][newMark]) {
                    queue.offer(new Node(i, newMark, node.step + 1));
                    visited[i][newMark] = true;
                }
            }
        }
        return -1;
    }

    private class Node {
        int curr;
        int mask;
        int step;

        public Node(int curr, int mask, int step) {
            this.curr = curr;
            this.mask = mask;
            this.step = step;
        }
    }

//    //用 set存储已访问过的结点。
//    public int shortestPathLength(int[][] graph) {
//
//        int N = graph.length;
//
//        Queue<Tuple> queue = new LinkedList<>();
//        // 用于避免走重复路径
//        Set<Tuple> set = new HashSet<>();
//
//        for (int i = 0; i < N; i++) {
//            int tmp = (1 << i);
//            set.add(new Tuple(tmp, i, 0));
//            queue.add(new Tuple(tmp, i, 0));
//        }
//
//        while (!queue.isEmpty()) {
//            Tuple curr = queue.remove();
//
//            if (curr.bitMask == (1 << N) - 1) {
//                // This path has visited all nodes, and it's guaranteed this is the shortest one by
//                // BFS so return it
//                return curr.cost;
//            } else {
//                int[] neighbors = graph[curr.curr];
//
//                for (int v : neighbors) {
//                    int bitMask = curr.bitMask;
//                    bitMask = bitMask | (1 << v);
//                    //将当前走过的路径和当前结点构造，在set中判断不存在时才继续
//                    Tuple t = new Tuple(bitMask, v, 0);
//                    if (!set.contains(t)) {
//                        queue.add(new Tuple(bitMask, v, curr.cost + 1));
//                        set.add(t);
//                    }
//                }
//            }
//        }
//        //无法到达
//        return -1;
//    }
//
//    private class Tuple {
//        int bitMask; //路径中已经走过的节点
//        int curr; // 当前
//        int cost; // 一共走了步数
//
//        public Tuple(int bit, int n, int c) {
//            bitMask = bit;
//            curr = n;
//            cost = c;
//        }
//
//        public boolean equals(Object o) {
//            Tuple p = (Tuple) o;
//            return bitMask == p.bitMask && curr == p.curr && cost == p.cost;
//        }
//
//        public int hashCode() {
//            return 1331 * bitMask + 7193 * curr + 727 * cost;
//        }
//    }

}
