package com.yuanshijia.javalearn.offer;

/**
 * @author yuanshijia
 * @date 2019-07-22
 * @description
 * 设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
 */
public class 链表中倒数第K个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        if (k > 0) {
            // 如果链表长度小于k，返回null
            return null;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
