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

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 *  I             1
 * V             5
 *  X             10
 * L             50
 *  C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: pengchenglin
 * @create: 2021-06-21 23:05
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("CXC"));
    }
    public static int getValue(char ch){
        switch (ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            case 'a':return 4;
            case 'b':return 9;
            case 'c':return 40;
            case 'd':return 90;
            case 'e':return 400;
            case 'f':return 900;
            default:return 0;
        }

    }

    /**
     * 将需要组合的两个字符替换成一个字符
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int result=0;
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        for(char ch:s.toCharArray()){
            result+=getValue(ch);
        }
        return result;
    }
    public int romanToInt(String s) {
        int value = 0;
        for(int i = 0;i<s.length();){
            if(s.charAt(i)=='I'){
                if(i+1<s.length()){
                    if(s.charAt(i+1)=='V'){
                        value+=4;
                        i++;
                        i++;
                        continue;
                    }else if(s.charAt(i+1)=='X'){
                        value+=9;
                        i++;
                        i++;
                    }else {
                        value+=1;
                        i++;
                        continue;
                    }
                    continue;
                }else {
                    value+=1;
                    i++;
                    continue;
                }

            }
            if(s.charAt(i)=='V'){
                value+=5;
                i++;
                continue;
            }

            if(s.charAt(i)=='X'){
                if(i+1<s.length()){
                    if(s.charAt(i+1)=='L'){
                        value+=40;
                        i++;
                        i++;
                        continue;
                    }else if(s.charAt(i+1)=='C'){
                        value+=90;
                        i++;
                        i++;
                        continue;
                    }else {
                        value+=10;
                        i++;
                        continue;
                    }
                }else {
                    value+=10;
                    i++;
                    continue;
                }
            }

            if(s.charAt(i)=='L'){
                value+=50;
                i++;
                continue;
            }
            if(s.charAt(i)=='C'){
                if(i+1<s.length()){
                    if(s.charAt(i+1)=='D'){
                        value+=400;
                        i++;
                        i++;
                        continue;
                    }else if(s.charAt(i+1)=='M'){
                        value+=900;
                        i++;
                        i++;
                        continue;
                    }else {
                        value+=100;
                        i++;
                        continue;
                    }
                }else {
                    value+=100;
                    i++;
                    continue;
                }
            }
            if(s.charAt(i)=='D'){
                value+=500;
                i++;
                continue;
            }
            if(s.charAt(i)=='M'){
                value+=1000;
                i++;
            }
        }
        return value;


    }

}
