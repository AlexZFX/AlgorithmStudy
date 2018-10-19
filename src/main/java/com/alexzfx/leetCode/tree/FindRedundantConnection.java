package com.alexzfx.leetCode.tree;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/10/19 10:14
 * Description : 684. 冗余连接
 * <p>
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * <p>
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * <p>
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 */
public class FindRedundantConnection {

    public static void main(String[] args) {
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        System.out.println(Arrays.toString(findRedundantConnection.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }

    // 并查集，union[i]表示i的父节点
    public int[] findRedundantConnection(int[][] edges) {
        int[] union = new int[1001];
        for (int[] edge : edges) {
            int r1 = find(edge[0], union);
            int r2 = find(edge[1], union);
            if (r1 == r2) {
                return edge;
            } else {
                union[r2] = r1;
            }
        }
        return null;
    }

    //找到 root的根节点
    private int find(int root, int[] union) {
        while (union[root] != 0) {
            root = union[root];
        }
        return root;
    }


//    邻接表存储，倒序dfs 没看到题目边的限制
//    public int[] findRedundantConnection(int[][] edges) {
//        List<Set<Integer>> graph = new ArrayList<>();
//        for (int[] edge : edges) {
//            //n+1行，第0行不用
//            while (graph.size() <= edge[1]) {
//                graph.add(new HashSet<>());
//            }
//            graph.get(edge[0]).add(edge[1]);
//            graph.get(edge[1]).add(edge[0]);
//        }
//        Set<Integer> set = new HashSet<>();
//        for (int i = edges.length - 1; i >= 0; i--) {
//            set.add(edges[i][0]);
//            if (canSearch(graph, edges[i][1], edges[i][0], set)) {
//                return edges[i];
//            }
//            set.clear();
//        }
//        return new int[]{};
//    }
//
//    private boolean canSearch(List<Set<Integer>> graph, int start, int root, Set<Integer> temp) {
//        if (graph.get(start).contains(root) && temp.size() > 1) {
//            return true;
//        } else {
//            temp.add(start);
//            boolean flag = false;
//            for (Integer point : graph.get(start)) {
//                if (!temp.contains(point)) {
//                    flag = canSearch(graph, point, root, temp);
//                }
//                if (flag) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
}
