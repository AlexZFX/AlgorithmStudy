package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/15 20:41
 * Description : 99. 恢复二叉搜索树
 * <p>
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class RecoverTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(2);
        RecoverTree recoverTree = new RecoverTree();
        recoverTree.recoverTree(node);
    }

    private TreeNode firstInvalidNode;
    private TreeNode lastInvalidNode;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        findInvalidNode(root);
        int temp = firstInvalidNode.val;
        firstInvalidNode.val = lastInvalidNode.val;
        lastInvalidNode.val = temp;
    }

    /**
     * pre 是比中序遍历的上个节点
     * 如果在中序遍历时节点值出现了两次降序，第一个错误的节点为第一次降序时较大的节点，第二个错误节点为第二次降序时较小的节点。
     * 比如，原来的搜索二叉树在中序遍历的节点值依次为{1,2,3,4,5}，如果因为两个节点位置错了而出现{1,5,3,4,2}，
     * 第一次降序为5->3，所以第一个错误节点为5，第二次降序为4->2,所以第二个错误节点为2，将5和2换过来就可以恢复。
     */
    private void findInvalidNode(TreeNode root) {
        if (root != null) {
            findInvalidNode(root.left);

            if (root.val < pre.val) {
                if (firstInvalidNode == null) {
                    firstInvalidNode = pre;
                }
                lastInvalidNode = root;
            }

            pre = root;
            findInvalidNode(root.right);
        }
    }


//    private int index = 0;
//
//    // O(n) 空间 利用中序遍历的有序性
//    public void recoverTree(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        Integer[] array = new Integer[list.size()];
//        list.toArray(array);
//        Arrays.sort(array);
//        inOrderTwo(root, array);
//    }
//
//    private void inOrderTwo(TreeNode root, Integer[] list) {
//        if (root != null) {
//            inOrderTwo(root.left, list);
//            root.val = list[index++];
//            inOrderTwo(root.right, list);
//        }
//    }
//
//    private void inOrder(TreeNode root, List<Integer> list) {
//        if (root != null) {
//            inOrder(root.left, list);
//            list.add(root.val);
//            inOrder(root.right, list);
//        }
//    }
}
