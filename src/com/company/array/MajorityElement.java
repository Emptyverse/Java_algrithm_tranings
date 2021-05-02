package com.company.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {-1,1,1,1,2,1};
        System.out.println(majorityElement2(nums));
    }
    //法1:map<元素,次数>,使用map记录出现次数,若超过n/2,则返回key
    public static int majorityElement(int[] nums) {
        //创建map接收key(数字)和value(出现次数)
        Map<Integer,Integer> map = new HashMap<>();
        int halflen = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 1;
            //若数字出现过则获取当前count,并自增
            if (map.containsKey(num)){
                count = map.get(num);
                count++;
            }
            //判断是否大于n/2,大于则直接返回num
            if(count > halflen){
                return num;
            }
            //首次出现则装进map中
            map.put(num,count);
        }
        return -1;
    }
    //先排序,然后判断,中间元素则为多数元素    #####错的#####
    public static int majorityElement1(int[] nums){
        Arrays.sort(nums);
        int halflen = nums.length/2;
        //若为数组长度为奇数,则返回中间值
        if (nums.length % 2 == 1){
            return nums[halflen];
        }
        //若为偶数
        else {
            //判断第一个和n/2+1的元素是否一致
            if(nums[0] == nums[halflen]){
                return nums[halflen];
            }
            //判断最后一个和n/2-1位置元素是否一致
            else if(nums[nums.length-1] == nums[halflen-1]){
                return nums[halflen];
            }
        }
        return -999;
    }
    public static int majorityElement2(int[] nums){
        int candidate = -1;
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
            }
            if (candidate == nums[i]){
                count++;
            }else {
                count--;
            }
        }

        return candidate;

    }

}
