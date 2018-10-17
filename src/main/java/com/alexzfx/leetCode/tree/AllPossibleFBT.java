package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/10/17 9:34
 * Description : 894. 所有可能的满二叉树
 * <p>
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * <p>
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * <p>
 * 答案中每个树的每个结点都必须有 node.val=0。
 * <p>
 * 你可以按任何顺序返回树的最终列表。
 */
public class AllPossibleFBT {

    public static void main(String[] args) {
        AllPossibleFBT allPossibleFBT = new AllPossibleFBT();
        allPossibleFBT.allPossibleFBT(7);
    }

    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return Collections.emptyList();
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        for (int i = 1; i < N; i += 2) {
            // 左边满二叉树的种类
            List<TreeNode> left = allPossibleFBT(i);

            List<TreeNode> right = allPossibleFBT(N - i - 1);
            TreeNode node;
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    node = new TreeNode(0);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }
        return list;
    }


}
