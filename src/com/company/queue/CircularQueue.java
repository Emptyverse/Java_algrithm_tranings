package com.company.queue;

public class CircularQueue {
    //存储元素的数组
    int[] queue;
    //队列头指针
    int head;
    //队列实际长度
    int count;
    //存储容量
    int capacity;
    public MyCircularQueue(int k) {
        //初始化队列
        capacity = k;
        queue = new int[k];
        head = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        //入队先判断队列是否满了
        if (isFull()) return false;
        //index指示队尾后一位
        int index = (head + count) % capacity;
        queue[index] = value;
        //长度自增
        count++;
        return true;
    }

    public boolean deQueue() {
        //出队要先判断队列是否为空
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        //长度自减
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[(head + count - 1) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
