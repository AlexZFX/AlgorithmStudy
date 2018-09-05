package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/7/29 18:22
 * Description : 203. 删除链表中的节点
 * 删除链表中等于给定值 val 的所有节点。
 */
public class RemoveElements {

    //高效递归解法
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

//    //个人解法
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) {
//            return null;
//        }
//        ListNode temphead = new ListNode(-1);
//        temphead.next = head;
//        ListNode temp = temphead;
//        while (temp.next.next != null) {
//            if (temp.next.val == val) {
//                temp.next = temp.next.next;
//            } else {
//                temp = temp.next;
//            }
//        }
//        if (temp.next.val == val) {
//            temp.next = null;
//        }
//        return temphead.next;
//    }
}
