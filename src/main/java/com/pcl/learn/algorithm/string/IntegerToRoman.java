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
 * @description:罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
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
 * 给你一个整数，将其转为罗马数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: pengchenglin
 * @create: 2021-06-23 00:04
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        String roman = new IntegerToRoman().intToRoman(4);
        System.out.println(roman);

    }
    public String intToRoman(int num) {
        String roman = "";
        for(int i = 1000;i>0;i=i/10){
            int quotient = num/i;
            int remainder = num%i;
            num = remainder;
            if(quotient==0){
                continue;
            }else {
                if(' '==getRoman(i*quotient)){
                    for(int x = 0;x<quotient;x++){
                        roman = roman+getRoman(i);
                    }
                }else {
                    roman = roman+getRoman(i*quotient);
                }

            }
        }
        roman = roman.replace("a","IV");
        roman = roman.replace("b","IX");
        roman = roman.replace("c","XL");
        roman = roman.replace("d","XC");
        roman = roman.replace("e","CD");
        roman = roman.replace("f","CM");

        roman = roman.replace("g","VI");
        roman = roman.replace("h","VII");
        roman = roman.replace("i","VIII");
        roman = roman.replace("j","LX");
        roman = roman.replace("k","LXX");
        roman = roman.replace("l","LXXX");
        roman = roman.replace("m","DC");
        roman = roman.replace("n","DCC");
        roman = roman.replace("o","DCCC");

        return roman;

    }

    public static char getRoman(int i){
        switch (i){
            case 1:return 'I';
            case 5:return 'V';
            case 10:return 'X';
            case 50:return 'L';
            case 100:return 'C';
            case 500:return 'D';
            case 1000:return 'M';
            case 4:return 'a';
            case 9:return 'b';
            case 40:return 'c';
            case 90:return 'd';
            case 400:return 'e';
            case 900:return 'f';
            case 6:return 'g';
            case 7:return 'h';
            case 8:return 'i';
            case 60:return 'j';
            case 70:return 'k';
            case 80:return 'l';
            case 600:return 'm';
            case 700:return 'n';
            case 800:return 'o';
            default:return ' ';
        }

    }
}