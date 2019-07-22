package com.yuanshijia.javalearn.offer;

/**
 * @author yuanshijia
 * @date 2019-07-22
 * @description
 */
public class 在O1时间内删除链表节点 {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return null;
        }
        if (head == tobeDelete) {
            // 如果只有一个节点
            head = null;
        } else if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            // 将下一个节点的值赋给该节点，然后删除下一个节点
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        } else {
            // 否则，遍历链表，找到节点的前一个节点，让前一个节点指向 null
            ListNode p = head;
            while (p.next != tobeDelete) {
                p = p.next;
            }
            p.next = null;
        }
        return head;
    }
    public static void main(String[] args) {
        
    }

}
