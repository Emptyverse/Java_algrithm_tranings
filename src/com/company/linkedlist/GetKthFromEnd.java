package com.company.linkedlist;

public class GetKthFromEnd {
    public static void main(String[] args) {
        int[] arr = {1,4,4,6,7,9};
        ListNode head = ListNode.arrayToListNode(arr);
        ListNode node = getKthFromEnd1(head, 3);
        System.out.println(node.data);
    }
    //遍历总长度 然后找到n-k+1位置的元素
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode tmp = head;
        //遍历链表长度
        while (tmp.next != null){
            n++;
            tmp= tmp.next;
        }
        tmp = head;
        //因为从0开始遍历到n-k位置即倒数第k个元素
        for (int i = 0; i < n-k+1; i++) {
            tmp  = tmp.next;

        }
        return tmp;
    }
    //法二: 快慢指针法
    public static ListNode getKthFromEnd1(ListNode head, int k){
        ListNode tmp1 = head;
        ListNode tmp2 = head;
        //倒数第几个快指针就先走几步
        for (int i = 1; i < k; i++) {
            tmp2 = tmp2.next;

        }
        while (tmp2.next != null){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return tmp1;
    }
}
