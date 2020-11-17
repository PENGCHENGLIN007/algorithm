package com.pcl.learn.algorithm.array;

/**
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *  如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 *  你可以假设数组中无重复元素。
 *
 *  示例 1:
 *
 *  输入: [1,3,5,6], 5
 * 输出: 2
 *
 *
 *  示例 2:
 *
 *  输入: [1,3,5,6], 2
 * 输出: 1
 *
 *
 *  示例 3:
 *
 *  输入: [1,3,5,6], 7
 * 输出: 4
 *
 *
 *  示例 4:
 *
 *  输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author pengchenglin
 * @create 2020-08-05 19:10
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6,7};
        int target = 3;
        System.out.println(new SearchInsert().searchInsert(nums,target));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了35.38% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len==0){return 0;}
        int start = 0;
        int end = len-1;
        //如果小于最小值，返回最小值
        if(nums[start]>target){return 0;}
        //如果大于最大值，返回最大值+1
        if(nums[end]<target){return len;}
        while(start<end){
            if(nums[start]==target){return start;}
            if(nums[end]==target){return end;}
            //如果在start和end之间，插入位置为end
            if((end-start)==1){return end;}

            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end = mid;
                if((end-start)==0){return end+1;}
            }else {
                start = mid;
                if((end-start)==0){return end;}
            }
        }
        return 0;

    }
}
