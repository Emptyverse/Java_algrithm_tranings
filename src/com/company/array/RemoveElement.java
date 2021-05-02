package com.company.array;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement1(nums,2));
    }
    //法1:双指针法
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //判断当前元素是否等于val,若相等覆盖当前index元素,index指向下一位
            if (nums[i] != val ){
                nums[index] = nums[i];
                index++;
            }

        }
        return index;
    }
    //法2:双指针调换元素法
    public static int removeElement1(int[] nums, int val)  {
        int index = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //若相同则交换最后一位
            if (nums[index] == val){
                nums[index] = nums[len - 1];
                //交换则长度减一
                len--;
                //当前位置还需继续遍历
                index--;
                }
            //若不等则指向下一位
            index++;
        }
        return len;
    }
}
