/*
 * Copyright 2021 Chenglin Peng.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pcl.learn.algorithm.string;

/**
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: pengchenglin
 * @create: 2021-07-06 22:07
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String prefix = new LongestCommonPrefix().longestCommonPrefix(new String[]{"abc","acd","afasdf"});
        System.out.println(prefix);
    }
    public String longestCommonPrefix(String[] strs) {
        String rs = "";
        out:for(int j = 0;j<strs[0].length();j++){
            char current = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++){
                if(j>=strs[i].length()){
                    break out;
                }
                if(strs[i].charAt(j)!=(current)){
                    break out;
                }

            }
            rs+=current;

        }
        return rs;

    }

    public String longestCommonPrefix2(String[] strs) {
        for(int j = 0;j<strs[0].length();j++){
            char current = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++){

                if(j>=strs[i].length() || strs[i].charAt(j)!=(current)){
                    return strs[0].substring(0,j);
                }

            }

        }
        return strs[0];

    }
}
