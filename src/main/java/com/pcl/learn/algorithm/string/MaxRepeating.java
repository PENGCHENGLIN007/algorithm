package com.pcl.learn.algorithm.string;


/**
 * @ClassName MaxRepeating
 * @Description TODO
 * @Author Chenglin Peng
 * @Data 2025/7/31 14:35
 * @Version F02SP02
 **/
public class MaxRepeating {
  public static int maxRepeating(String sequence, String word) {
    int count = 0;
    int x = 0;
    int max = 0;
    for(int i = 0;i<sequence.length();i++){
      if(sequence.charAt(i) == word.charAt(x)){
        x++;
        if(x == word.length()){
          x = 0;
          count++;
          if(count>max){
            max = count;
          }
        }
      }else {
        if(count>0){
          i = i -x - word.length();
        }else {
          i = i -x;
        }
        x = 0;
        count = 0;
      }
    }
    return max;

  }

  public static void main(String[] args) {
    String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
    String word = "aaaba";
    int count = maxRepeating(sequence,word);
    System.out.println(count);

  }

}
