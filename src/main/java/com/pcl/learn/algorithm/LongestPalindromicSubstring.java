package com.pcl.learn.algorithm;

/**
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author pengchenglin
 * @create 2020-06-29 10:52
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aaaa";
        String result = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(result);

    }

    /**
     * 中心扩散法
     * 回文数有两种类型1：112211，2:12321
     * 执行用时：9 ms, 在所有 Java 提交中击败了95.26%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了23.21%的用户
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        char[] c = s.toCharArray();

        int length = 0;
        int star = 0,end = 0;
        for(int i=0;i<c.length-1;i++){
            if(i+1<c.length && c[i]==c[i+1]) {
                int tmp;

                int x = i;
                int y = i+1;
                while(x>=0 && y<c.length && c[x]==c[y]){
                    x--;
                    y++;
                }

                tmp = y-x+1-2;

                if(tmp>length){
                    length = tmp;
                    x++;
                    y--;
                    star = x;
                    end = y;
                }
            }

            if(i-1 >=0 && i+1<c.length && c[i-1]==c[i+1]){
                int tmp;
                int x = i-1;
                int y = i+1;
                while(x>=0 && y<c.length && c[x]==c[y]){
                    x--;
                    y++;
                }
                tmp = y-x+1-2;
                if(tmp>length){
                    length = tmp;
                    x++;
                    y--;
                    star = x;
                    end = y;
                }

            }

        }
        return s.substring(star,end+1);

    }
}
