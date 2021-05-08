package com.company.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //添加元素 add()报错 offer()不报错
        queue.add(1);
        queue.offer(1);//更友好
        queue.offer(2);
        queue.offer(3);
        //只获取队头元素 queue.peek()返回空  queue.element()抛出异常
        queue.peek();//更好
        queue.element();
        //获取队头元素并取出
        queue.peek();//更友好
        queue.element();
    }
}
