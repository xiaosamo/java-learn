package com.yuanshijia.javalearn.offer;

/**
 * @author yuanshijia
 * @date 2019-07-24
 * @description
 */
public class 反转链表 {
    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }


    /**
     * 三指针
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        // 指向当前节点
        ListNode currentNode = head;
        // 指向当前节点的前一个节点
        ListNode prevNode = null;

        ListNode prevHead = null;

        while (currentNode != null) {
            //  指向当前节点的后一个节点
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                // 如果是最后一个节点，那么这个就是反转后的头节点
                prevHead = currentNode;
            }
            // 将当前节点的指针指向前一节点
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevHead;
    }


    /**
     * 头插法
     *
     * @param head
     * @return
     */
    public ListNode ReverseList3(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        ListNode ListNode = new ListNode(1);
        ListNode.next = new ListNode(2);
        ListNode.next.next = new ListNode(3);
        ListNode reverseList = new 反转链表().ReverseList2(ListNode);

        while (reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }

    }
}
