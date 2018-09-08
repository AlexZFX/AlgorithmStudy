package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/9/8 10:29
 * Description : 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        //需要调换的节点个数
        int num = n - m + 1;
        if (num == 1) {
            return tempHead.next;
        }
        //pre为需调换结点的前一个
        ListNode pre = tempHead, mid, post;
        //若 m = 1，则pre = tempHead
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        //翻转的前一个
        ListNode l = pre;
        pre = pre.next;
        //翻转的开头
        mid = pre.next;
        for (int i = 1; i < num; i++) {
            post = mid.next;
            mid.next = pre;
            pre = mid;
            mid = post;
        }
        //中间段的头指向后端头
        l.next.next = mid;
        //前段尾指向后段尾
        l.next = pre;
        return tempHead.next;
    }
}
