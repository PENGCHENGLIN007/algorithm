package com.pcl.learn.algorithm.string;


/**
 * @ClassName ValidPalindrome
 * @Description TODO
 * @Author Chenglin Peng
 * @Data 2025/7/29 10:04
 * @Version F02SP02
 **/
public class ValidPalindrome {
  public static boolean isPalindrome(String s) {
    char[] chars = s.toCharArray();
    int l = 0;
    int r = chars.length-1;
    while (l<r){
      while (chars[l]<48 || (chars[l]>57 && chars[l]<65) || (chars[l]>90 && chars[l]<97) || chars[l]>122){
        l++;
        if(l>=chars.length){
          return true;
        }
      }
      while (chars[r]<48 || (chars[r]>57 && chars[r]<65) || (chars[r]>90 && chars[r]<97) || chars[r]>122){
        r--;
        if(r<0){
          return true;
        }
      }
      if(l>=r){
        return true;
      }
      if(l<r && (chars[l] ==chars[r] || (chars[l]>64 && chars[r]>64 && (chars[l]+32 == chars[r] || chars[l]-32 == chars[r])))){
        l++;
        r--;
      }else {
        return false;
      }
    }
    return true;

  }

  public static void main(String[] args) {
    String s = "\"Sue,\" Tom smiles, \"Selim smote us.\"";
    boolean rs = isPalindrome(s);
    System.out.println(rs);
  }

}
