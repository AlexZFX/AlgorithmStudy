package com.alexzfx.leetCode.linkedList;

/**
 * Author : Alex
 * Date : 2018/5/3 20:46
 * Description :
 */
public class MergeTwoLists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        ListNode p = null;
        while (l1 != null && l2 != null) {
            if (head == null) {
                if (l1.val < l2.val) {
                    head = l1;
                    p = head;
                    l1 = l1.next;
                } else {
                    head = l2;
                    p = head;
                    l2 = l2.next;
                }
                continue;
            }
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head;
    }

}
