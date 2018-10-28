package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/10/1 9:54
 * Description : 160. 相交链表
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        int num = 0;//计算长度差值
        boolean isALong = false;
        while (pA.next != null || pB.next != null) {
            if (pA.next == null) {
                while (pB.next != null) {
                    ++num;
                    pB = pB.next;
                }
            } else if (pB.next == null) {
                while (pA.next != null) {
                    ++num;
                    pA = pA.next;
                }
                isALong = true;
            } else {
                pA = pA.next;
                pB = pB.next;
            }
        }
        if (pA != pB) {
            return null;
        }
        pA = headA;
        pB = headB;
        if (isALong) {
            while (num > 0) {
                pA = pA.next;
                --num;
            }
        } else {
            while (num > 0) {
                pB = pB.next;
                --num;
            }
        }
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
