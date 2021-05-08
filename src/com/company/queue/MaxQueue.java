package com.company.queue;

import java.util.LinkedList;

public class MaxQueue {
    public static void main(String[] args) {
        //目前还不会
    }
    //原始队列
    LinkedList<Integer> originqueue = new LinkedList<>();
    //max存储最大值的候选值
    LinkedList<Integer> maxqueue = new LinkedList<>();
    public MaxQueue() {
        originqueue = new LinkedList<>();
        maxqueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxqueue.isEmpty()){
            return -1;
        }
        return  maxqueue.peekFirst();
    }
    //当对尾新增元素e时 max队列中从队尾开始比较,
    //若e>max  若max元素都小于e则清空队列,e进max队
    //若e<max 将其直接存到max队列中
    public void push_back(int value) {
        originqueue.offer(value);
        //首先判空
        while (!maxqueue.isEmpty() && maxqueue.peekLast() <= value){
            maxqueue.pollLast();
        }
        maxqueue.offer(value);
    }
    //出队时要判断删除元素是否等于最大值,若等则出队
    public int pop_front() {
        if (!maxqueue.isEmpty() && originqueue.peek().equals(maxqueue.peekFirst())){
            //若相等 则最大值候选队列出队
            maxqueue.pollFirst();
        }
        //若初始队列为空
        if (originqueue.isEmpty()){
            return -1;
        }
        //初始队列出队
        return originqueue.poll();
    }
}
