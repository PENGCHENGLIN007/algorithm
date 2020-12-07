package com.pcl.learn.algorithm.list;

/**
 *
 * //给你一个链表数组，每个链表都已经按升序排列。
 * //
 * // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * //输出：[1,1,2,3,4,4,5,6]
 * //解释：链表数组如下：
 * //[
 * //  1->4->5,
 * //  1->3->4,
 * //  2->6
 * //]
 * //将它们合并到一个有序链表中得到。
 * //1->1->2->3->4->4->5->6
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：lists = []
 * //输出：[]
 * //
 * //
 * // 示例 3：
 * //
 * // 输入：lists = [[]]
 * //输出：[]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // k == lists.length
 * // 0 <= k <= 10^4
 * // 0 <= lists[i].length <= 500
 * // -10^4 <= lists[i][j] <= 10^4
 * // lists[i] 按 升序 排列
 * // lists[i].length 的总和不超过 10^4
 * //
 *
 * @author pengchenglin
 * @create 2020-11-27 11:12
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(5);
        l3.next = new ListNode(7);
        l3.next.next = new ListNode(41);

        ListNode l4 = new ListNode(35);
        l4.next = new ListNode(71);
        l4.next.next = new ListNode(81);

        ListNode l5 = new ListNode(20);
        l5.next = new ListNode(33);
        l5.next.next = new ListNode(66);
        ListNode[] listNodes = new ListNode[]{l1,l2,l3,l4,l5};

        MergeKLists mergeKLists = new MergeKLists();
        ListNode rs = mergeKLists.mergeKLists1(listNodes);
        System.out.println(rs);
    }

    /**暴力解法：遍历数组，合并当前链表和下一链表，并将下一链表替换为合并的结果
     *
     * 执行耗时:277 ms,击败了12.54% 的Java用户
     * 内存消耗:41 MB,击败了14.61% 的Java用户
     *
     * 不使用递归的情况：
     * 执行耗时:124 ms,击败了20.25% 的Java用户
     * 内存消耗:39.8 MB,击败了94.08% 的Java用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0){return null;}
        if(k==1){return lists[0];}
        for(int i = 0;i<k-1;i++){

            lists[i+1] = mergeTwoLists(lists[i],lists[i+1]);
        }
        return lists[k-1];

    }

    public ListNode mergeKLists1(ListNode[] lists) {
        int k = lists.length;
        if(k==0){return null;}
        if(k==1){return lists[0];}
        int count = (int) Math.ceil(Math.log(k)/Math.log(2));
        for(int j = 0;j<count;j++){
            for(int i = 0;i<k;){
                int two = i+(int)Math.pow(2,j);
                ListNode tmp2;
                if(two>k-1){tmp2 = null;}else{
                    tmp2 = lists[i+(int)Math.pow(2,j)];
                }

                lists[i] = mergeTwoLists1(lists[i],tmp2);
                i = i+(int)Math.pow(2,j+1);
            }

        }

        return lists[0];

    }

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

}
