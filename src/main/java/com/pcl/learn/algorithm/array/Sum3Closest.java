package com.pcl.learn.algorithm.array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pengchenglin
 * @create 2020-07-15 19:37
 */
public class Sum3Closest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(new Sum3Closest().threeSumClosest(nums,2));
    }

    /**
     * 执行耗时:7 ms,击败了44.97% 的Java用户
     * 内存消耗:39.7 MB,击败了6.82% 的Java用户
     *
     * 时间复杂度：O(N^2)O(N2)，其中 NN 是数组 \textit{nums}nums 的长度。
     * 我们首先需要 O(N \log N)O(NlogN) 的时间对数组进行排序，随后在枚举的过程中，
     * 使用一重循环 O(N)O(N) 枚举 aa，双指针 O(N)O(N) 枚举 bb 和 cc，故一共是 O(N^2)O(N2)。
     *
     * 空间复杂度：O(\log N)O(logN)。排序需要使用 O(\log N)O(logN) 的空间。
     * 然而我们修改了输入的数组 \textit{nums}nums，在实际情况下不一定允许，
     * 因此也可以看成使用了一个额外的数组存储了 \textit{nums}nums 的副本并进行排序，
     * 此时空间复杂度为 O(N)O(N)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/3sum-closest/solution/zui-jie-jin-de-san-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        if(nums==null || nums.length<3){
            throw new IllegalArgumentException("no solution");
        }
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        int L,R;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            L = i+1;
            R = nums.length-1;

            while (L<R){
                int sum = nums[i]+nums[L]+nums[R];
                int diff = Math.abs(target-sum);
                int ansDiff = Math.abs(target-ans);
                if(diff<ansDiff){
                    ans = sum;
                }
                if(sum>target){

                    while (L<R && nums[R-1]==nums[R]){
                        R--;
                    }
                    R--;
                }
                if(sum<target){
                    while (L<R && nums[L+1]==nums[R]){
                        L++;
                    }
                    L++;
                }
                if(sum==target){return target;}
            }
        }
        return ans;

    }
}
