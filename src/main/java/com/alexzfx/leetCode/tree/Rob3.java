package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/15 13:26
 * Description : 337. 打家劫舍 III
 */
public class Rob3 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // res[0] 选择当前节点的最大值， res[1] 不选择当前节点的最大值
    private int[] dfs(TreeNode node) {
        int[] res = {0, 0};
        if (node != null) {
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            //选择当前结点则必可以选择 不选l1和r1的
            res[0] = node.val + left[1] + right[1];
////            不选当前节点可以 l0,r0(选左右)  l1,r1(左右和自己都不选，下一层会选自己)  l1,r0(选右不选左)  l0,r1(选左不选右)
//            res[1] = Math.max(Math.max(left[0] + right[0], left[1] + right[1]), Math.max(left[0] + right[1], left[1] + right[0]));
            res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        }
        return res;
    }
}
