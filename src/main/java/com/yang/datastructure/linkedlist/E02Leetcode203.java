package com.yang.datastructure.linkedlist;

import com.yang.datastructure.linkedlist.ListNode;

public class E02Leetcode203 {
    /**
     * @param head 链表头
     * @param val  目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                // 删除，p2向后移
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public ListNode removeElements(ListNode p, int val) {
        if(p == null) {
            return null;
        }
        if (p.val == val) {
            return removeElements(p.next, val);
        } else {
            p.next = removeElements(p.next, val);
            return p;
        }
    }

    public static void main(String[] args) {
//        ListNode head = ListNode.of(1, 2, 6 ,3 ,6);
        ListNode head = ListNode.of(1, 1, 1, 1, 1);
        System.out.println(head);
        System.out.println(new E02Leetcode203().removeElements(head, 1));
    }
}
