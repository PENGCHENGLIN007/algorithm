package com.pcl.learn.algorithm.list;

/**
 * singly-linked list
 *
 * @author pengchenglin
 * @create 2020-11-19 14:26
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode listNode = this;

        while (listNode.next!=null){
            int t = listNode.next.val;
            listNode = listNode.next;
            sb.append("->");
            sb.append(t);
        }

        return sb.toString();

    }
}
