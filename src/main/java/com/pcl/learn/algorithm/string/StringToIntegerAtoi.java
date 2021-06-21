package com.pcl.learn.algorithm.string;

/**
 * @description: 实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *              函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，
 * 大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: pengchenglin
 * @create: 2021-05-07 07:14
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String s = "-2147483649";
        int rs = new StringToIntegerAtoi().myAtoi(s);
        System.out.println(rs);

    }
    public int myAtoi(String s) {
        int rs = 0;
        boolean positive = true;
        char[] c = s.toCharArray();
        int len = c.length;
        if(len==0){return 0;}
        int i = 0;
        //1.去掉前导空格
        while (i<len && c[i]==32  ){
            i++;
        }
        if(i==len){return 0;}
        //2.确定符号
        if(c[i]==43){
            i++;
            //正数
            positive = true;
        }else if(c[i]==45){
            i++;
            //负数
            positive = false;
        }else if(c[i]<48 || c[i]>57){
            //第一个字符非数字
            return 0;
        }
        if(i==len){return 0;}
        //3.去掉最前面的0
        while(i<len  && c[i]==48 ){
            i++;
        }
        if(i==len){return 0;}

        for(;i<len;i++){
            if(c[i]<48 || c[i]>57){
                break;
            }
            if(positive && (rs>Integer.MAX_VALUE/10 || (rs==Integer.MAX_VALUE/10 && c[i]>'7'))){
                return Integer.MAX_VALUE;
            }
            if(!positive && (rs>Math.abs(Integer.MIN_VALUE/10) || (-rs==Integer.MIN_VALUE/10 && c[i]>'8'))){
                return Integer.MIN_VALUE;
            }
            rs = rs*10+(c[i]-'0');

        }
        if(!positive){
            rs = 0-rs;
        }
        return rs;

    }
}
