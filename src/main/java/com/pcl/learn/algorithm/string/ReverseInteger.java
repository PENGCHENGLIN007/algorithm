package com.pcl.learn.algorithm.string;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author pengchenglin
 * @create 2020-07-06 20:10
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int a = new ReverseInteger().reverse(1000);
        System.out.println(a);
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了24.06%的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了5.33%的用户
     *
     * 分两种情况，大于0和小于0，转为char，如果以0结尾，去掉0
     * @param x
     * @return
     */
    public int reverse(int x) {
        String source = String.valueOf(x);

        char[] c = source.toCharArray();
        char[] result = new char[source.length()];
        if(x<0){
            for(int i=source.length()-1;i>0;i--){
                result[source.length()-i] = c[i];
            }
            result[0] = '-';

        }else{
            for(int i=source.length()-1;i>=0;i--){
                result[source.length()-1-i] = c[i];
            }
        }
        try{
            return Integer.valueOf(String.valueOf(result));
        }catch (Exception e){
            return 0;
        }


    }

    /**
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.1 MB, 在所有 Java 提交中击败了5.33%的用户
     *
     * 作者：LeetCode
     *     链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
