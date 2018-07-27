package com.alexzfx.nowCoder.swordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author : Alex
 * Date : 2018/3/12 17:06
 * Description :
 */
public class sword3 {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一个链表，从尾到头打印链表每个节点的值。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

}
