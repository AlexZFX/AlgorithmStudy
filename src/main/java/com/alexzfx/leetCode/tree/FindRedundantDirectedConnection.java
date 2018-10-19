package com.alexzfx.leetCode.tree;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/10/19 12:01
 * Description : 685. 冗余连接 II
 * <p>
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u and v和顶点的边，其中父节点u是子节点v的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 */
public class FindRedundantDirectedConnection {

    public static void main(String[] args) {
        FindRedundantDirectedConnection connection = new FindRedundantDirectedConnection();
        System.out.println(Arrays.toString(connection.findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}})));
    }


    // 有向图，且能去边后形成树，则最多只有一个节点存在2个母节点。
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] union = new int[1001];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
        int[] temp = null;
        for (int[] edge : edges) {
            //找到第二个结点的根节点，
            int r2 = union[edge[1]];
            //说明r2有2个父结点，应该删除一个
            if (r2 != edge[1]) {
                temp = edge;
            } else {
                if (union[0] != 1) {
                    int r1 = find(edge[0], union);
                    if (r1 == edge[1]) {
                        union[0] = 1;
                        if (temp == null) {
                            temp = edge;
                        }
                    }
                }
                //说明成环,成环之后find会进入死循环
                union[edge[1]] = edge[0];
            }
        }
        if (temp != null) {
            //如果成环了的话，则temp必然不是导致成环的边（因为没有被添加到union中去）
            if (union[0] == 1) {
                return new int[]{union[temp[1]], temp[1]};
            } else if (find(temp[0], union) == find(temp[1], union)) {
                return temp;
            } else {
                return new int[]{union[temp[1]], temp[1]};
            }
        }
        return null;
    }

    private int find(int num, int[] union) {
        while (union[num] != num) {
            num = union[num];
        }
        return num;
    }
}
