package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/7/24 11:48
 * Description : 142 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        //是否有环，true 为有环，false为无环
        boolean flag = true;
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                flag = false;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果有
        if (flag) {
            //一个从当前位置继续，一个从头开始，再次相遇则为环的开始结点
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }
}
