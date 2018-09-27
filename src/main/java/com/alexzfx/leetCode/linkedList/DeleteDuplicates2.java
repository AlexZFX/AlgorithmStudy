package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/9/27 14:03
 * Description : 82. 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode pre = tempHead, now = head;
        boolean delete = false;
        while (now != null && now.next != null) {
            while (now.next != null && now.val == now.next.val) {
                now.next = now.next.next;
                delete = true;
            }
            if (delete) {
                pre.next = now.next;
                now = pre.next;
            } else {
                pre = pre.next;
                now = pre.next;
            }
            delete = false;
        }
        return tempHead.next;
    }
}
