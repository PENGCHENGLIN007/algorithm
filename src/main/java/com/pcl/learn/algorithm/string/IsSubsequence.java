package com.pcl.learn.algorithm.string;


/**
 * @ClassName IsSubsequence
 * @Description TODO
 * @Author Chenglin Peng
 * @Data 2025/7/30 11:17
 * @Version F02SP02
 **/
public class IsSubsequence {

  public static boolean isSubsequence(String s, String t) {
    int n = s.length(), m = t.length();
    int[][] f = new int[m + 1][26];
    for (int i = 0; i < 26; i++) {
      f[m][i] = m;
    }
    for (int i = m - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        if (t.charAt(i) == j + 'a') {
          f[i][j] = i;
        } else {
          f[i][j] = f[i + 1][j];
        }
      }
    }
    int add = 0;
    for (int i = 0; i < n; i++) {
      if (f[add][s.charAt(i) - 'a'] == m) {
        return false;
      }
      add = f[add][s.charAt(i) - 'a'] + 1;
    }
    return true;
  }

public static void main(String[] args) {
  String s = "abc";
  String t = "adhbddc";
  boolean rs = isSubsequence(s, t);
  System.out.println(rs);

}

}
