package com.company.linkedlist;

public class RingList {
    public static void main(String[] args) {
        int[] arr = {1,4,4,6,7,9};
        ListNode node = ListNode.arrayToListNode(arr);
        System.out.println(hasCycle(node));
    }
    public static ListNode hasCycle(ListNode head) {
        //初始判断链表是否为空或是否只有一个元素
        if (head == null || head.next == null){
            //return false;
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        //循环遍历
        while (true){
            //当fast跳到空或fast下一位为空
            if (fast == null|| fast.next == null) {
                //return false;
                return null;
            }
            //快慢指针遍历
            slow = slow.next;
            fast = fast.next.next;
            //当slow和fast相等则返回true
            if (slow == fast){
                //return true;
                break;
            }
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
