package com.company.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber3(nums));
    }
    //法1:利用set集合
    public static int findRepeatNumber(int[] nums) {
        Set<Integer>  set  = new HashSet<>();
        //遍历数组
        for (int num : nums) {
            //如果在集合中则返回,不在则添加进集合中
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
    //法2:先排序后查找 排序后重复元素相邻
    public static int findRepeatNumber1(int[] nums) {
        //直接使用操作数组的工具类,排序
        Arrays.sort(nums);
        //itar循环快捷键,通过判断相邻元素是否相等 返回是否重复
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return nums[i];
            }

        }
        return -1;
    }
    //法3:临时数组来记录出现过的数字
    public static int findRepeatNumber2(int[] nums){
        //创建临时数组 默认为0
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(tmp[num] != 0){
                return num;
            }
            tmp[num] = 1;

        }
        return -1;
    }
    //法4:索引匹配,遍历的同时交换位置
    public static int findRepeatNumber3(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            //如果索引正好等于元素本身 则跳过
            int num = nums[i];
            if (nums[i] == i) continue;
            if (nums[num] == num){
                return num;
            }
            //若不等则交换nums[i]和nums[num]
            int tmp = nums[num];
            nums[i] = tmp;
            nums[num] = num;
            //交换完i重新回归 即--
            i--;


        }
        return -1;
    }
}

