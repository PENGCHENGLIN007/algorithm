package com.pcl.learn.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author pengchenglin
 * @create 2020-06-04 16:56
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring2(s);
        System.out.println(result);
    }

    /**
     * 执行用时 :259 ms, 在所有 Java 提交中击败了7.82%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了5.20%的用户
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int sublongestLength = 0;
        int longestLength = 0;
        if(s.length()<=1){
            return s.length();
        }
        for(int i=0;i<s.length();i++){
            if(sublongestLength>longestLength){
                longestLength = sublongestLength;
            }

            for(int j=i+1;j<s.length();j++){
                String substring = s.substring(i,j);
                if(substring.contains(String.valueOf(s.charAt(j)))){


                        sublongestLength = substring.length();

                    break;

                }
                sublongestLength = substring.length()+1;

            }
        }
        return longestLength;

    }

    /**
     * 官方解答
     *
     * 执行用时：8 ms, 在所有 Java 提交中击败了69.00%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了5.20%的用户
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
