package com.pcl.learn.algorithm.everyweek;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * @author pengchenglin
 * @create 2020-11-06 16:35
 */
public class HammingDistance {
    public static void main(String[] args) {
        //0000 0001
        //0000 0101
        int x = 1,y = 5;
        int xor = x ^ y;
        Integer.bitCount(xor);
        System.out.println(xor);
        System.out.println(Integer.toBinaryString(xor));

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.2 MB, 在所有 Java 提交中击败了89.30%的用户
     *
     * 转成二进制String,去掉0数1
     * 执行用时：1 ms, 在所有 Java 提交中击败了11.15%的用户
     * 内存消耗：35.2 MB, 在所有 Java 提交中击败了87.87%的用户
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        //String bs = Integer.toBinaryString(xor);
        //bs = bs.replace("0","");
        int r=0;
        while (xor>0){
            int a = xor%2;
            xor = xor/2;
            if(a==1){
                r++;
            }

        }

        return r;


    }

    /**
     * 最优解
     *
     * 布赖恩·克尼根位计数算法
     * xor和xor-1做AND操作后，xor的最右边等于1的比特会被移除。
     * @param x
     * @param y
     * @return
     */
    public int optimal(int x, int y){
        int xor = x ^ y;
        int r=0;
        while (xor!=0){
            r++;
            xor = xor & (xor-1);
        }
        return r;

    }
}
