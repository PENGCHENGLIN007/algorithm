package com.pcl.learn.algorithm.list;

/**
 *
 * //将两个升序链表合并为一个新的 升序 链表并返回。
 * // 新链表是通过拼接给定的两个链表的所有节点组成的。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：1->2->4, 1->3->4
 * //输出：1->1->2->3->4->4
 *
 * @author pengchenglin
 * @create 2020-11-20 17:19
 */
public class MergeTwoLists {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode rs = new MergeTwoLists().mergeTwoLists1(l1,l2);
        //ListNode rs = new MergeTwoLists().mergeTwoLists(l1,l2);
        System.out.println(rs.toString());

    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.6 MB,击败了95.79% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode rs = new ListNode(0);
        ListNode rs1 = rs;


        while (t1!=null || t2!=null){
            if(t1==null){
                rs1.next = t2;
                t2 = t2.next;
                rs1 = rs1.next;
                break;
            }else if(t2==null) {
                rs1.next = t1;
                t1 = t1.next;
                rs1 = rs1.next;
                break;
            }
            if(t1.val>t2.val){
                rs1.next = t2;
                t2 = t2.next;
            }else {
                rs1.next = t1;
                t1 = t1.next;
            }
            rs1 = rs1.next;
        }
        return rs.next;

    }

    /**
     * 官方递归实现
     * 作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }




}
