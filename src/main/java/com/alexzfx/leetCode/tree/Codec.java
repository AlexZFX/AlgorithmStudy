package com.alexzfx.leetCode.tree;

import com.alexzfx.leetCode.struct.TreeNode;

/**
 * Author : Alex
 * Date : 2018/10/18 12:28
 * Description : 449. 序列化和反序列化二叉搜索树
 * <p>
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */
public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = new TreeNode(-1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        System.out.println(codec.serialize(treeNode));
        treeNode = codec.deserialize(codec.serialize(treeNode));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#");
            return;
        }
        sb.append(node.val);
        sb.append(' ');
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[1];
        return deserialize(data, index);
    }

    private TreeNode deserialize(String data, int[] index) {
        if (data.charAt(index[0]) == '#') {
            ++index[0];
            return null;
        }
        int val = 0;
        while (data.charAt(index[0]) != ' ') {
            if (data.charAt(index[0]) == '-') {
                ++index[0];
                val = 10 * val - data.charAt(index[0]) + '0';
            } else {
                val = 10 * val + data.charAt(index[0]) - '0';
            }
            ++index[0];
        }
        ++index[0];
        TreeNode node = new TreeNode(val);
        node.left = deserialize(data, index);
        node.right = deserialize(data, index);
        return node;
    }

}
