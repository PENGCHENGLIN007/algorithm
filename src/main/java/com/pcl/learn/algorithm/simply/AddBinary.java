package com.pcl.learn.algorithm.simply;

/**
 * @ClassName AddBinary
 * @Description
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Chenglin Peng
 * @Data 2022/1/11 0:27
 * @Version F01
 **/
public class AddBinary {

  public static void main(String[] args) {

    String a = "1010";
    String b = "1011";
    String rs = AddBinary.addBinary(a,b);
    System.out.println(rs);

  }
  public static String addBinary(String a, String b) {
    int step = 0;

    if(a.length()<b.length()){
      String c = a;
      a = b;
      b = c;
    }
    char[] ac = a.toCharArray();
    char[] bc = b.toCharArray();

    StringBuilder sb = new StringBuilder();
    for(int i = a.length() -1;i>=0;i--){
      char ai = ac[i];
      char bi = '0';
      int bo = i-(a.length()-b.length());
      if(bo>=0){
        bi = bc[bo];
      }
      if(98==ai+bi){
        if(step==0){
          sb.append(0);
        }else {
          sb.append(1);
        }
        step=1;
      }else if(97==ai+bi){
        if(step==0){
          sb.append(1);
        }else {
          sb.append(0);
          step = 1;
        }

      }else if(96==ai+bi){
        if(step==0){
          sb.append(0);
        }else {
          sb.append(1);
          step=0;
        }
      }
    }
    if(step==1){
      sb.append(1);
    }
    return sb.reverse().toString();

  }

}
