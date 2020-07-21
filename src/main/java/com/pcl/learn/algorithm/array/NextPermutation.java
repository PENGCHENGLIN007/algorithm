package com.pcl.learn.algorithm.array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *123111
 *131112
 * 1333111
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pengchenglin
 * @date 2020/7/20 22:14
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(nums));
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    /**
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums.length==0){return;}
        int len = nums.length;
        for(int i = 1;i<len;i++){
            if(nums[i]<nums[i-1]){
                int e = i;
                do{
                    e--;
                }while(nums[e]==nums[e-1]);
                int tmp1 = nums[e];
                nums[e] = nums[e-1];
                nums[e-1] = tmp1;
                //将e+1之后的数据从小到大排序
                for(int x = e+1;x<len;x++){
                    for(int y = e+1;y<len-x;y++){
                        if(nums[y]>nums[y+1]){
                            int tmp2 = nums[y];
                            nums[y]=nums[y+1];
                            nums[y+1] = tmp2;
                        }
                    }
                }
                break;


            }
            if(nums[i]>=nums[i-1]){
                if(i==len-1){
                    int n = 0;
                    //数组逆序
                    for(int j = 0;j<len/2;j++){
                        int tmp = nums[j];
                        nums[j] = nums[len-j-1];
                        nums[len-j-1] = tmp;
                    }
                }
            }
        }

    }
}
