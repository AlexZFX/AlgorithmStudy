package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/8/4 17:06
 * Description : 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cur = dummy;
        //前一个节点比后一个节点少走n步，后一节点走到尾时，前一结点走到倒数第n个(从head开始时)，
        // n >= 0，故n走了n+1个
        while (n >= 0 && cur != null) {
            cur = cur.next;
            n--;
        }
        while (cur != null) {
            //pre是从head前一个开始。
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = pre.next.next;

        return dummy.next;
    }


//    //利用栈实现的解法
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null || n == 0) {
//            return null;
//        }
//        Stack<ListNode> stack = new Stack<ListNode>();
//        ListNode node = head;
//        while (node != null) {
//            stack.push(node);
//            node = node.next;
//        }
//        ListNode now, pre;
//        int num = 0;
//        while (!stack.isEmpty()) {
//            now = stack.pop();
//            ++num;
//            if (num == n) {
//                if (now == head) {
//                    return head.next;
//                } else {
//                    pre = stack.pop();
//                    pre.next = now.next;
//                    return head;
//                }
//            }
//        }
//        return head;
//    }
}
