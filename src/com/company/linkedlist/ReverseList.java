package com.company.linkedlist;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp = null;
        while (cur != null){
            tmp = cur.next;
            pre = cur;
            cur.next = pre;
            cur = tmp;
        }
        return cur;

    }
}
