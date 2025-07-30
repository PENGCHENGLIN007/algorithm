package com.pcl.learn.algorithm.simply;


import java.util.Arrays;

/**
 * @ClassName CountBit
 * @Description TODO
 * @Author Chenglin Peng
 * @Data 2025/7/30 10:06
 * @Version F02SP02
 **/
public class CountBit {
  public static int[] countBits(int n) {
    int[] rs = new int[n+1];
    for(int i = 0;i<=n;i++){
      int count = 0;
      int ii = i;
      while (ii!=0){
        count += ii & 1;
        ii = ii >> 1;
      }
      rs[i] = count;
    }
    return rs;

  }

  public static void main(String[] args) {
    int n = 2;
    System.out.println(Arrays.toString(countBits(n)));

  }

}
