package com.pcl.learn.algorithm.array;

import java.util.Arrays;

/**
 * @author pengchenglin
 * @create 2020-07-20 15:34
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,3,3,3,3,1,2,3,2};
        System.out.println(new RemoveElement().removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.4 MB,击败了5.68% 的Java用户
     *
     * 双指针法，i,j，i从0开始遍历，j从尾部开始，nums[i]==val时，和nums[j]交换位置，nums[j]
     * 不能为val，否则，j--,当i==j时，遍历结束。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length==0){return 0;}
        int i = 0;
        int j = nums.length-1;
        for(;i<nums.length;i++){
            if(nums[i]==val){
               while (i<j && nums[j]==val){
                   j--;
               }
               if(i==j){
                   return i;
               }
               nums[i] = nums[j];
               nums[j] = val;
            }
        }
        return i;
    }
}
