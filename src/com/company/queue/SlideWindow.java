package com.company.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlideWindow {
    public static void main(String[] args) {
        int[] arr = {};
        int[] result =maxSlidingWindow(arr,3);
        System.out.println(Arrays.toString(result));
    }
    public static int[] maxSlidingWindow(int[] nums, int k){
        //对数组进行判空,k也要判断
        if(nums.length == 0 || k == 0) return new int[0];
        //记录每个窗口的最大值 n-k+1为形成窗口的个数
        int[] result = new int[nums.length - k + 1];
        //使用队列记录最大值的候选值,具体实现类为数组
        Deque<Integer> deque = new ArrayDeque<>();
        //窗口未形成阶段,1-k窗口
        for (int i = 0; i < k; i++) {
            //每次deque中的尾元素与新元素比较,小于尾元素则候选值直接进队,大于则尾出队
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        //第一个窗口形成,返回最大值result
        result[0] = deque.peekFirst();
        //队列形成后
        for (int i = k; i < nums.length; i++) {
            //此时为i-k+1次滑动,每次滑动
            //先判断滑动窗口时删除的值是否为deque队列中的队头元素,若是deque出队,删除的第一个元素为i-k
            if (deque.peekFirst() == nums[i-k]){
                deque.pollFirst() ;
            }
            //继续存储最大值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            //当前result
            result[i-k+1] = deque.peekFirst();
        }
        return result;
    }
}
