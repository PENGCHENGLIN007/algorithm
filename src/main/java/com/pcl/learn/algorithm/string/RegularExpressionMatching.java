package com.pcl.learn.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**

/**
 * @description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: pengchenglin
 * @create: 2021-06-01 08:22
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b*";
        boolean result = new RegularExpressionMatching().isMatch(s,p);
        System.out.println(result);
    }
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;

        while(i<s.length() && j<p.length()){
            char sc = s.charAt(i);
            char pc = p.charAt(j);
            if(pc=='.'){
                i++;
                j++;
            }else if(pc=='*'){
                char pre = p.charAt(j-1);
                if( pre=='*'){
                    return false;
                }else{
                    while (i<s.length() && (s.charAt(i)==pre || pre=='.')){
                        i++;
                    }
                    j++;
                }

            }else {
                if(sc!=pc){
                    return false;
                }
                i++;
                j++;

            }
        }

        if(i==s.length() && j==p.length()){
            return true;
        }else {
            return false;
        }

    }
}
