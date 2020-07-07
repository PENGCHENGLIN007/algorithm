package com.pcl.learn.algorithm;

import java.util.Stack;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pengchenglin
 * @create 2020-06-28 19:29
 */
public class MediansOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {4};
        int[] nums2 = {1,2,3};
        double medians = new MediansOfTwoSortedArrays().findMedianSortedArrays(nums1,nums2);
        System.out.println(medians);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if( length1==0 && length2==1){
            return nums2[0];
        }
        if( length2==0 && length1==1){
            return nums1[0];
        }
        if( length2==0) return length1%2==0?((double)(nums1[(length1/2-1)]+nums1[length1/2])/2)
                :nums1[length1/2];
        if(length1 == 0) return length2%2==0?((double)(nums2[(length2/2-1)]+nums2[length2/2])/2)
                :nums2[length2/2];

        Stack stack1=new Stack();
        Stack stack2=new Stack();
        for(int i1:nums1){
            stack1.push(i1);
        }
        for(int i2:nums2){
            stack2.push(i2);
        }
        int count = 0;
        while (true){
            if((length1+length2)%2==0){
                if(count==(length1+length2)/2-1){
                    int item1;
                    int item2;
                    if(stack1.empty()){
                        item1 = (int)stack2.peek();
                        stack2.pop();
                        item2 = (int)stack2.peek();
                        return (double)(item1+item2)/2;
                    }
                    if(stack2.empty()){
                        item1 = (int)stack1.peek();
                        stack1.pop();
                        item2 = (int)stack1.peek();
                        return (double)(item1+item2)/2;
                    }
                    if((int)stack1.peek()<(int)stack2.peek()){
                        item1 =  (int)stack2.peek();
                        stack2.pop();
                        if(stack2.empty()){
                            item2 = (int)stack1.peek();
                            return (double)(item1+item2)/2;
                        }
                        if((int)stack1.peek()<(int)stack2.peek()){
                            item2 = (int)stack2.peek();

                        }else {
                            item2 = (int)stack1.peek();

                        }
                    }else{
                        item1 =  (int)stack1.peek();
                        stack1.pop();
                        if(stack1.empty()){
                            item2 = (int)stack2.peek();
                            return (double)(item1+item2)/2;
                        }
                        if((int)stack1.peek()<(int)stack2.peek()){
                            item2 = (int)stack2.peek();

                        }else {
                            item2 = (int)stack1.peek();

                        }
                    }
                    return (double)(item1+item2)/2;
                }
            }
            if((length1+length2)%2!=0){
                if(count==(length1+length2)/2){

                    if(stack1.empty()){
                        return (int)stack2.peek();
                    }
                    if(stack2.empty()){
                        return (int)stack1.peek();
                    }

                    if((int)stack1.peek()<(int)stack2.peek()){
                        return (int)stack2.peek();
                    }else{
                        return (int)stack1.peek();
                    }
                }

            }
            if(stack1.empty() && !stack2.empty()){
                stack2.pop();
                count++;
            }
            if(stack2.empty() && !stack1.empty()){
                stack1.pop();
                count++;
            }
            if(!stack1.empty() && !stack2.empty()){


                if ((int)stack1.peek()<(int)stack2.peek()){
                    stack2.pop();
                    count++;
                }else{
                    stack1.pop();
                    count++;
                }
            }
        }





    }

    /**
     * 作者：windliang
     *     链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


}
