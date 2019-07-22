package com.yuanshijia.javalearn.offer;

import java.util.Arrays;

/**
 * @author yuanshijia
 * @date 2019-07-22
 * @description
 */
public class 删除链表中重复的结点 {

    /**
     * 删除重复的节点，重复的节点不保留
     * 1,2,2,3,3,4 -> 1,4
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            // 如果链表为空，或者只有一个节点，直接返回
            return pHead;
        }

        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            // 如果节点重复，直接抛弃，然后递归
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(next);
        }
        return pHead;
    }

    /**
     * 删除重复的节点，重复的节点保留一个
     * 1,2,3,4,4,5 -> 1,2,3,4,5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            // 如果链表为空，或者只有一个节点，直接返回
            return pHead;
        }

        ListNode next = pHead.next;
        while (next != null && pHead.val == next.val) {
            next = next.next;
        }
        pHead.next = deleteDuplication2(next);
        return pHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);


        ListNode listNode = new 删除链表中重复的结点().deleteDuplication(head);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}
