package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/9/11 11:33
 * Description : 143. 重排链表
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node);
    }

    //翻转后半部分的list，然后依次加在后部。
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = head, tail = head, head2, p;
        while (tail != null && tail.next != null) {
            mid = mid.next;
            tail = tail.next.next;
        }
        if (tail == null) {
            head2 = mid;
        } else {
            head2 = mid.next;
        }
        head2 = reverse(head2);
        while (head != null && head2 != null) {
            p = head2;
            head2 = head2.next;
            p.next = head.next;
            head.next = p;
            head = p.next;
        }
        if (head != null) {
            head.next = null;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, now = head.next, post;
        while (now != null) {
            post = now.next;
            now.next = pre;
            pre = now;
            now = post;
        }
        head.next = null;
        return pre;
    }

//    //使用LinkedList实现。 效率较低
//    public void reorderList(ListNode head) {
////        ListNode tempHead = new ListNode(-1);
////        tempHead.next = head;
//        LinkedList<ListNode> listNodes = new LinkedList<ListNode>();
//        while (head != null) {
//            listNodes.addLast(head);
//            head = head.next;
//        }
//        ListNode pre, end;
//        while (!listNodes.isEmpty()) {
//            pre = listNodes.pollFirst();
//            end = listNodes.pollLast();
//            if (end == null) {
//                //listNodes不为空，pre不可能为空
//                pre.next = null;
//                return;
//            } else if (pre.next == end) {
//                end.next = null;
//                return;
//            }
//            end.next = pre.next;
//            pre.next = end;
//        }
//    }
}
