package com.pcl.learn.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengchenglin
 * @create 2020-07-16 17:34
 */
public class Sum4 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(new Sum4().fourSum(nums,-1));

    }

    /**
     * 执行耗时:20 ms,击败了43.37% 的Java用户
     * 内存消耗:40.1 MB,击败了10.53% 的Java用户
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length<4){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){

            if(i>0 && nums[i]==nums[i-1]){continue;}

            for(int j = i+1;j<nums.length-2;j++){

                if(j>i+1 && nums[j]== nums[j-1]){continue;}

                int L,R;
                L = j+1;
                R = nums.length-1;
                while(L<R){
                    int sum = nums[i]+nums[j]+nums[L]+nums[R];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        while (L<R && nums[L+1]==nums[L]){L++;}
                        while (L<R && nums[R-1]==nums[R]){R--;}
                        L++;
                        R--;
                    }else if(sum>target){
                        R--;

                    }else{
                        L++;
                    }
                }

            }
        }
        return ans;

    }

    /**
     * 执行耗时:4 ms,击败了92.37% 的Java用户
     * 	内存消耗:40.3 MB,击败了10.53% 的Java用户
     * 对fourSum增加大小值判断
     *
     *
     * 参考：https://leetcode-cn.com/problems/4sum/solution/ji-bai-9994de-yong-hu-you-dai-ma-you-zhu-shi-by-yo/
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        //定义结果集
        List<List<Integer>> ans = new ArrayList<>();
        //如果数组为空，或者长度小于4，没有结果，直接返回空集
        if(nums== null || nums.length<4){
            return  ans;
        }
        //对数组进行排序，时间复杂度NlogN
        Arrays.sort(nums);
        //定义四个指针，i,j,L,R，i从0开始遍历，j从i+1开始，L从j+1,R从nums.length-1（即最后一个元素）
        // 第一层循环
        for(int i = 0;i<nums.length-3;i++){

            //当最小的和比目标值大时，后面的肯定会越来越大,直接退出循环
            int min1 = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min1>target){break;}

            //当前循环的最大和小于目标值时，之后的和也会越来越小，肯定小于目标值，
            //所以直接进入下次循环
            int max1 = nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1];
            if(max1<target){continue;}

            //当第二个之后的元素和前一个相同时，会出现重复结果，直接跳过
            if(i>0 && nums[i-1]== nums[i]){continue;}

            //第二层循环
            for(int j=i+1;j<nums.length-2;j++){

                //当第二个之后的元素和前一个相同时，会出现重复结果，直接跳过
                if(j>i+1 && nums[j-1]==nums[j]){continue;}

                //当最小的和大于目标值时，后面的和会越来越大，可以退出循环
                int min2 = nums[i]+nums[j]+nums[j+1]+nums[j+2];
                if(min2>target){break;}

                //当最大的和小于目标值时，进行下一次循环
                int max2 = nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1];
                if(max2<target){continue;}

                //L R 双指针判断结果
                int L = j+1;
                int R = nums.length-1;
                while (L<R){
                    int sum = nums[i]+nums[j]+nums[L]+nums[R];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        L++;
                        R--;
                        while (L<R && nums[L]==nums[L-1]){L++;}
                        while (L<R && nums[R]==nums[R+1]){R--;}
                    }else if(sum>target){
                        R--;
                    }else {
                        L++;
                    }


                }
            }
        }
        return ans;

    }
}
