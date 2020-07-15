package com.pcl.learn.algorithm.array;

/**盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author pengchenglin
 * @create 2020-07-07 19:24
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int rs = new ContainerWithMostWater().maxArea2(height);
        System.out.println(rs);

    }

    /**
     * 暴力解法
     * 执行用时：726 ms, 在所有 Java 提交中击败了5.62%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了21.43%的用户
     *
     * 时间复杂度：O(N*N)，双指针总计最多遍历整个数组一次。
     *
     * 空间复杂度：O(1)，只需要额外的常数级别的空间。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int rs = 0;
        for(int i = 0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int tmp = (j-i)*(height[i]<height[j]?height[i]:height[j]);
                if(tmp>rs) rs = tmp;
            }
        }
        return rs;

    }

    /**
     * 双指针法
     *
     * 两个指针初始位置在数组两端，左指针向右移动，右指针向左移动，每当指针对应的值较小时移动指针。
     * 假设两端分别为x,y，距离为t,当x<=y时，则容量为x*t，
     * 如果移动右指针，容量始终不会超过x*t，所以，移动较小的指针是合理的。
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了92.67%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了16.43%的用户
     *
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
     *
     * 空间复杂度：O(1)，只需要额外的常数级别的空间。
     *
     * @param hight
     * @return
     */
    public int maxArea2(int[] hight){
        int x = 0;
        int y = hight.length-1;
        int max = 0;
        while (x!=y){
            int t = (hight[x]>hight[y]?hight[y]:hight[x])*(y-x);
            max = max>t?max:t;
            if(hight[x]<=hight[y]){
                x++;
            }else {
                y--;
            }
        }
        return max;

    }
}
