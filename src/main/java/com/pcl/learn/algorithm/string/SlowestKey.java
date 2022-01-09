package com.pcl.learn.algorithm.string;

/**
 * @ClassName SlowestKey
 * @Description https://leetcode-cn.com/problems/slowest-key/
 * @Author Chenglin Peng
 * @Data 2022/1/9 23:04
 * @Version F01
 **/
public class SlowestKey {

  public static void main(String[] args) {

  }
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    char maxKey = keysPressed.charAt(0);
    int maxTimes = releaseTimes[0];
    for(int i = 1;i<releaseTimes.length;i++){
      if(releaseTimes[i]-releaseTimes[i-1]>maxTimes){
        maxKey = keysPressed.charAt(i);
        maxTimes = releaseTimes[i]-releaseTimes[i-1];
      }else if(releaseTimes[i]-releaseTimes[i-1]==maxTimes){
        maxKey = maxKey>keysPressed.charAt(i)?maxKey:keysPressed.charAt(i);
      }
    }
    return maxKey;

  }

}
