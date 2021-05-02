package com.company.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4};
        System.out.println(findDisappearedNumbers1(nums));
        System.out.println(nums);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //使用set 存储已出现的数字
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        //从1-n开始遍历
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)){
                result.add(i);
            }

        }
        return result;

    }
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //每一次提取当前值的绝对值
            int num = Math.abs(nums[i]);
            //找到对应下标位置
            int index = num - 1;
            //判断当前值是否已经存在,因为存在即为被修改过
            if (nums[index] > 0){
                //修改为负值
                nums[index] = -nums[index];
            }
        }
        //遍历数组,未被修改为负值的添加到新列表中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                //当前数要比i大1
                result.add(i+1);
            }
        }
        return result;

    }
}
