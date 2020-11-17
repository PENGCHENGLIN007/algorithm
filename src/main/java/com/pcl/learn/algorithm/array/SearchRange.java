package com.pcl.learn.algorithm.array;

import java.util.Arrays;

/**
 *
 * //给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * // 找出给定目标值在数组中的开始位置和结束位置。
 * //
 * // 你的算法时间复杂度必须是 O(log n) 级别。
 * //
 * // 如果数组中不存在目标值，返回 [-1, -1]。
 * //
 * // 示例 1:
 * //
 * // 输入: nums = [5,7,7,8,8,10], target = 8
 * //输出: [3,4]
 * //
 * // 示例 2:
 * //
 * // 输入: nums = [5,7,7,8,8,10], target = 6
 * //输出: [-1,-1]
 *
 * @author pengchenglin
 * @create 2020-08-05 16:28
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums,target)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.1 MB,击败了43.49% 的Java用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len==0){return new int[]{-1,-1};}
        int start = 0;
        int end = len-1;

        while (start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                int left = mid-1;
                int right = mid+1;
                while (left>=0 && nums[left]==target){
                    left--;
                }
                while (right<= end && nums[right]==target){
                    right++;
                }
                left++;
                right--;
                return new int[]{left,right};
            }else if(nums[mid]>target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }

        return new int[]{-1,-1};

    }
}
