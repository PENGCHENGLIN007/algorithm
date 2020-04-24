package com.pcl.learn.algorithm;

import java.util.Arrays;

/**
 * 两数之和
 *
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pengchenglin
 * @create 2020-04-24 20:01
 */
public class TwoNumberSum {

    public static int[] twosum(int[] nums,int target){
        int[] result = new int[2];
        int testsum;
        int tmp;
        if(nums.length==0){
            return null;
        }
        /*for(int x = 0;x<nums.length;x++){
            for(int y = 0;y<nums.length-x-1;y++){
                if(nums[y]>nums[y+1]){
                    tmp = nums[y];
                    nums[y] = nums[y+1];
                    nums[y+1] = tmp;
                }
            }
        }*/
        outterLoop:for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>target){
                    break;
                }
                testsum = nums[i]+nums[j];
                if(testsum==target){
                    result[0] = i;
                    result[1] = j;
                    break outterLoop;
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,112,333,14123,552354};
        int target = 14456;
        int[] result = twosum(nums,target);
        System.out.println(Arrays.toString(result));


    }

}
