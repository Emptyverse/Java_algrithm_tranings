package com.company.array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    //双指针
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            //如果不同则更新index
            if (nums[index] != nums[i]){
                //index自加并更新index值
                index++;
                nums[index] = nums[i];
            }

        }
        //返回数组长度为index+1
        return index+1;
    }
}
