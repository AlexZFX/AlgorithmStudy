package com.alexzfx.leetCode.linkedList;

import com.alexzfx.leetCode.struct.ListNode;

/**
 * Author : Alex
 * Date : 2018/7/23 17:12
 * Description : 147
 * 对链表进行插入排序。
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode answer = insertionSortList.insertionSortList(null);
        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        //待遍历的节点第一个
        ListNode pointer = head.next;
        //已排好序的最后一节点
        ListNode end = head;
        while (pointer != null) {
            //需要进行一次插入排序时
            if (pointer.val < end.val) {
                //保存当前遍历到的结点
                ListNode test = root;
                while (test.next != pointer) {
                    if (pointer.val < test.next.val) {
                        //
                        end.next = pointer.next;
                        pointer.next = test.next;
                        test.next = pointer;
                        pointer = end.next;
                        break;
                    }
                    test = test.next;
                }
            } else { // 不需要进行排序时
                end = pointer;
                pointer = pointer.next;
            }
        }
        return root.next;
    }
}
