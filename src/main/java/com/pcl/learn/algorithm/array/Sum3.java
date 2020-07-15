package com.pcl.learn.algorithm.array;

import java.util.*;

/**
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pengchenglin
 * @create 2020-07-10 20:44
 */
public class Sum3 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(new Sum3().threeSum(nums).toString());
    }

    /**
     * 超时。。
     * 遍历数组，固定，nums[i]，求剩余元素中，两数之和等于0-nums[i]的结果，
     * 将nums[i]合并到list中，构成三元组；
     * 再将结果排序去重。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int[] tmp = new int[nums.length-1-i];
            for(int j = i+1;j<nums.length;j++){
                tmp[j-i-1] = nums[j];
            }
            List<List<Integer>> twoSum = twoSum(tmp,0-nums[i]);
            if(twoSum.size()!=0){
                for(int x = 0;x<twoSum.size();x++){
                    twoSum.get(x).add(nums[i]);
                    Collections.sort(twoSum.get(x));
                }
                lists.addAll(twoSum);
                Collections.sort(lists, (o1, o2) -> {
                    if(o1.size()!=o2.size()){
                        return -1;
                    }
                    for(int i1 = 0; i1 <o1.size(); i1++){
                        if(o1.get(i1).compareTo(o2.get(i1))==0){
                            continue;
                        }else if(o1.get(i1).compareTo(o2.get(i1))<0){
                            return -1;
                        }else{
                            return 1;
                        }
                    }
                    return 0;
                });
                Integer[] compare = new Integer[3];
                Iterator<List<Integer>> iterator = lists.iterator();
                while(iterator.hasNext()){
                    List<Integer> list = iterator.next();
                    boolean flag = true;
                    for(int y=0;y<compare.length-1;y++){
                        if(!list.get(y).equals(compare[y])){
                            flag = false;
                        }
                    }
                    if (flag){
                        iterator.remove();
                    }else{
                        compare =  list.toArray(new Integer[3]);
                    }

                }
            }
        }
        return lists;

    }
    private List<List<Integer>> twoSum(int[] nums1,int target){
        Map<Integer,Integer> map = new HashMap<>(nums1.length);
        List<List<Integer>> twoList = new ArrayList<>();
        for (int i=0;i<nums1.length;i++){
            if(map.containsKey(target-nums1[i])){
                final int ii = i;
                twoList.add(new ArrayList<Integer>(){
                    {
                        add(target-nums1[ii]);
                        add(nums1[ii]);
                    }
                });
            }
            map.put(nums1[i],i);
        }
        return twoList;
    }

    /**
     * 执行用时：22 ms, 在所有 Java 提交中击败了94.37%的用户
     * 内存消耗：43.5 MB, 在所有 Java 提交中击败了98.74%的用户
     *
     * 先排序，遍历数组，固定nums[i]
     * 如果nums[i]>0，跳过
     * 从左右向中间遍历剩余元素，如果左右元素+固定元素=0，加入结果；
     * 并且左指针右移，右指针左移，如果遇到重复元素，继续移动。
     * 如果小于0，右移左指针；如果大于0，左移右指针。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums==null || len<3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0;i<len-2;i++){
            if(nums[i]>0){
                break;
            }
            int left = i+1;
            int right = len-1;
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left+1]==nums[left]){
                        left++;
                    }
                    while(left<right && nums[right-1]==nums[right]){
                        right--;
                    }
                    left++;
                    right--;

                }
                if(sum<0){
                    left++;
                }
                if (sum>0){
                    right--;
                }
            }

        }
        return ans;
    }

}
