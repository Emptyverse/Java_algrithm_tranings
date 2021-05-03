package com.company.linkedlist;

public class ListNode {
    //数据
    int data;
    //下一个节点的引用
    ListNode next;
    public ListNode(int data){

        this.data = data;
    }
    public static ListNode arrayToListNode(int[] arr) {
        if (arr.length == 0) return null;
        //生成链表的根节点
        ListNode root = new ListNode(arr[0]);
        ListNode pre = root;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            pre.next = node;
            pre = node;

        }
        return root;
    }
}
