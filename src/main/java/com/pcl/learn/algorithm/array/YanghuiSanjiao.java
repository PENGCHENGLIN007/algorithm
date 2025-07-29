package com.pcl.learn.algorithm.array;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName YanghuiSanjiao
 * @Description TODO
 * @Author Chenglin Peng
 * @Data 2025/7/29 14:27
 * @Version F02SP02
 **/
public class YanghuiSanjiao {
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> rs = new ArrayList<>();
    for(int i = 0;i<numRows;i++){
      List<Integer> rss = new ArrayList<>();
      rs.add(rss);
      for(int j = 0;j<i+2;j++){
        if(j == 0 || j == i+1){
          rss.add(1);
        }else {
          if(i-1<0){
            continue;
          }
          rss.add(j,rs.get(i-1).get(j-1)+rs.get(i-1).get(j));
        }

      }
    }
    return rs;

  }

  public static void main(String[] args) {
    List<List<Integer>> rs = generate(3);
    System.out.println(rs.toString());

  }

}
