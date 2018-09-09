package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/9/8 19:24
 * Description : 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return mergeSort(head);
    }

    //归并排序
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        //尾节点不该为空，故要求next.next != null
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head = mergeSort(head);
        head2 = mergeSort(head2);
        return merge(head, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode res, p;
        if (head1.val < head2.val) {
            res = head1;
            head1 = head1.next;
        } else {
            res = head2;
            head2 = head2.next;
        }
        p = res;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                p = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                p = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            p.next = head2;
        } else {
            p.next = head1;
        }
        return res;
    }
}
