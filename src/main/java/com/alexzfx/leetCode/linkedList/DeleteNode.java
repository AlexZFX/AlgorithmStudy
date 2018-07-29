package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/7/29 17:13
 * Description : 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，
 * 你将只被给定要求被删除的节点。
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

//    public void deleteNode(ListNode node) {
//        while (node.next.next != null) {
//            node.val = node.next.val;
//            node = node.next;
//        }
//        node.val = node.next.val;
////        node = node.next;
//        node.next = null;
//    }
}
