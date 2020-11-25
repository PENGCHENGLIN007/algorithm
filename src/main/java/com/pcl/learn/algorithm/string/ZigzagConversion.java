package com.pcl.learn.algorithm.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author pengchenglin
 * @create 2020-07-02 19:55
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        String result = new ZigzagConversion().convert(s,3);
        System.out.println(result);

    }

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了38.20%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了8.33%的用户
     * 将每行的字符存到list中，最后合并
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }

        List<Integer> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0;i<numRows;i++){
            list.addAll(getList(length,i,numRows));
        }
        StringBuilder stringBuilder = new StringBuilder(length);
        for(int sub:list){
            stringBuilder.append(chars[sub]);
        }
        return stringBuilder.toString();

    }

    /**
     * 计算每行的结果
     * @param length
     * @param i
     * @param numRows
     * @return
     */
    public List<Integer> getList(int length,int i,int numRows){
        List<Integer> list = new LinkedList<>();
        int step = 2*numRows-2;
        if(i==0){
            for(int x=0;x*step<length;x++){
                list.add(x*step);
            }
        }else if(i==numRows-1){
            for(int x=0;x*step+numRows-1<length;x++){
                list.add(x*step+numRows-1);
            }
        }else {
            for(int x=0;x*step+i<length;x++){
                list.add(x*step+i);
                int secondIndex = (x*2+1)*step-x*step-i;
                if(secondIndex<length){
                    list.add(secondIndex);
                }

            }

        }
        return list;
    }

    /**
     *
     * 简洁实现
     *执行用时：9 ms, 在所有 Java 提交中击败了46.52%的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了8.33%的用户
     *
     * 作者：jyd
     *     链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }


}
