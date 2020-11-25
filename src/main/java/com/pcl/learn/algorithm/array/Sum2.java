package com.pcl.learn.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class Sum2 {

    /**
     * 从第一个元素开始，逐一和之后的元素求和，判断是否是目标值。
     * 执行用时 :88 ms, 在所有 Java 提交中击败了17.46%的用户
     * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了5.06%的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twosum(int[] nums,int target){
        int[] result = new int[2];
        int testsum;
        if(nums.length==0){
            return null;
        }

        outterLoop:for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){

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

    /**
     * 将数组元素放到map中，key为元素值，value为元素数组下标；
     * 遍历数组，目标值减去数组元素，得到的差值，判断是否在map中，且不是当前数组元素，是则返回。
     * 执行用时 :3 ms, 在所有 Java 提交中击败了86.05%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.06%的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twosumMapImpl(int[] nums,int target){
        Map<Integer,Integer> numsMap = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            numsMap.put(nums[i],i);
        }
        for(int j=0;j<nums.length;j++){
            int item = target-nums[j];
            if(numsMap.containsKey(item) && numsMap.get(item)!=j){
                return new int[]{j,numsMap.get(item)};
            }
        }
        //运行时异常，无需throws
        throw new  IllegalArgumentException("no solution");
    }

    /**
     * 无法通过，例如[3,3],6
     * @param nums
     * @param target
     * @return
     */
    public static int[] twosumMapImpl2(int[] nums,int target){
        Map<Integer,Integer> numsMap = new HashMap<>(nums.length);
        for(int i = 0;i<nums.length;i++){
            numsMap.put(nums[i],i);
            int item = target-nums[i];
            if(numsMap.containsKey(item)&& numsMap.get(item)!=i){
                if(i>numsMap.get(item)){
                    return new int[]{numsMap.get(item),i};
                }
                return new int[]{i,numsMap.get(item)};
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    /**
     * 简洁的map实现
     * @param nums
     * @param target
     * @return
     */
    public static int[] twosumMapImpl3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result = twosumMapImpl(nums,target);
        System.out.println(Arrays.toString(result));


    }

}
