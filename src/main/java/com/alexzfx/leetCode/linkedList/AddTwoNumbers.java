package com.alexzfx.leetCode.linkedList;

/**
 * Author : Alex
 * Date : 2018/5/4 9:50
 * Description : 2 fin
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 空间复杂度O(1) 时间复杂度O(n)
 */
public class AddTwoNumbers {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = l1;
        ListNode p = head;
        int add = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + add;
            if (sum >= 10) {
                add = 1;
                l1.val = sum % 10;
            } else {
                add = 0;
                l1.val = sum;
            }
            p = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (add == 1) {
                p.next = new ListNode(1);
            }
        } else {
            if (l2 == null) {
                l2 = l1;
            }
            p.next = l2;
            while (add == 1) {
                if (l2 == null) {
                    p.next = new ListNode(1);
                    add = 0;
                    continue;
                }
                sum = l2.val + 1;
                if (sum == 10) {
                    l2.val = 0;
                    p = l2;
                    l2 = l2.next;
                } else {
                    l2.val = sum;
                    add = 0;
                }
            }
        }
        return head;
    }

}
