package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/8/28 23:36
 * Description : 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre, now, post;
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        pre = tempHead;
        now = tempHead.next;
        while (now != null) {
            post = now.next;
            if (post == null) {
                break;
            }
            pre.next = post;
            now.next = post.next;
            post.next = now;
            pre = now;
            now = pre.next;
        }
        return tempHead.next;
    }
}
