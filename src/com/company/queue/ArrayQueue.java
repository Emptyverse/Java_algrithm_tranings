package com.company.queue;

public class ArrayQueue {
    //存储元素,声明头尾指针
    int head;
    int tail;
    int[] arr;
    int maxCapacity;

    public ArrayQueue(int maxCapacity) {
        arr = new int[maxCapacity];
        maxCapacity = maxCapacity;
        head = 0;
        tail = 0;
    }
    public boolean isFull(){
        return tail == maxCapacity;
    }
    public void add(int n){
        //判断队列的容量大小
        if (!isFull()){
        arr[tail] = n;
        }
    }
    public boolean isEmpty(){
        return head == tail;
    }
    public int get(){
        //判断是否为空
        if (isEmpty()) return -1;
        int result = arr[head];
        head++;
        return result;
    }
}
