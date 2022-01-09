package com.pcl.learn.algorithm.string;

/**
 * @ClassName LengthOfLastWord
 * @Description TODO
 * @Author Chenglin Peng
 * @Data 2022/1/9 23:57
 * @Version F01
 **/
public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    int len = 0;
    for(int i = s.length()-1;i>=0;i--){
      char c = s.charAt(i);
      if(c!=32){
        len++;
      }else {
        if(len>0){
          return len;
        }

      }
    }
    return len;

  }

}
