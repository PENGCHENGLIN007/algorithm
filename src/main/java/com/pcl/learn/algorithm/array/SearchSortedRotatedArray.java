package com.pcl.learn.algorithm.array;

/**
 * @author pengchenglin
 * @create 2020-08-04 16:22
 */
public class SearchSortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(new SearchSortedRotatedArray().search(nums,0));

    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了95.93% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0){return -1;}
        if(len==1 && nums[0] == target){return 0;}
        if(len==1 && nums[0] != target){return -1;}
        int start = 0;
        int end = len-1;
        while (start<end){
            if(target==nums[start]){return start;}
            if(target==nums[end]){return end;}
            int middle = (start+end)/2;
            if(target == nums[middle]){
                return middle;
            }else if(target>nums[start] && target<nums[middle]){
                end = middle-1;
            }else if(target>nums[middle] && target<nums[end]){
                if(target==nums[end]){return end;}
                start = middle+1;

            }else if(nums[start]<nums[middle]){
                start = middle+1;

            }else{
                end = middle-1;

            }
        }
        return -1;

    }
}
