package com.pcl.learn.algorithm.simply;

import java.util.Arrays;

/**
 * @ClassName PlusOne
 * @Description https://leetcode-cn.com/problems/plus-one/
 * @Author Chenglin Peng
 * @Data 2022/1/10 23:18
 * @Version
 **/
public class PlusOne {

  public static void main(String[] args) {
    int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
    System.out.println(Arrays.toString(PlusOne.plusOne(digits)));
  }
  public static int[] plusOne(int[] digits) {
    int step = 0;
    if(digits[digits.length-1]==9){
      digits[digits.length-1] = 0;
      step = 1;
    }else {
      digits[digits.length-1]+=1;
    }
    for(int i = digits.length-2;i>=0;i--){
      if(digits[i]==9){
        if(step==1){
          digits[i] = 0;
        }
      }else {
        digits[i]= digits[i]+step;
        step = 0;
      }
    }
    if(step==1){
      int[] r = new int[digits.length+1];
      r[0] = 1;
      for(int j = 1;j<r.length;j++){
        r[j] = digits[j-1];
      }
      return r;
    }else {
      return digits;
    }

  }


}
