package com.pcl.learn.algorithm.list;

/**
 *
 * //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * //
 * // 示例：
 * //
 * // 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * //
 * //当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * //
 * //
 * // 说明：
 * //
 * // 给定的 n 保证是有效的。
 * //
 *
 * @author pengchenglin
 * @create 2020-11-19 14:28
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head.toString());
        ListNode r = new RemoveNthFromEnd().removeNthFromEnd(head,2);
        System.out.println(r.toString());
    }

    /**
     * 遍历求得链表长度，len-n-1表示需要删除节点的父节点位置fromSt
     * 如果fromSt小于0，表示没有父节点，只有头节点没有父节点，所以删除头节点。
     * 之后，根据fromSt删除对应位置的节点。
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了66.33%的用户
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode t = head;
        while (t.next!=null){
            t = t.next;
            len++;
        }
        int fromSt = len-n-1;
        if(fromSt<0){
            return head.next;
        }
        ListNode t1 = head;
        while (fromSt>0){
            fromSt--;
            t1 = t1.next;

        }
        t1.next = t1.next.next;
        return head;
    }
}
