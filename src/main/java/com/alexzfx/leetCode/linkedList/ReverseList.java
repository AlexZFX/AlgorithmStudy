package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/7/29 15:36
 * Description : 206. 反转链表
 * 反转一个单链表。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode now = head.next;
        ListNode next = head.next.next;
        head.next = null;
        while (now != null) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
