package com.pcl.learn.algorithm;

/**
 * 两数相加
 *
 * @author pengchenglin
 * @create 2020-06-01 20:24
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(8);
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(6);
        ListNode result = addTwoNumbers(l1,l2);
        do {
            System.out.print(result.val);
            result = result.next;
        }
        while (!(result.val==0 && result.next==null));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        if(l1.val==0 && l2.val==0){
            sum = new ListNode(0);
            return sum;
        }
        if(l1.val==0){
            return l2;
        }
        if(l2.val==0){
            return l1;
        }
        ListNode tmp1 = l1.next;
        int l1length = 1;
        int l2length = 1;
        while (tmp1!=null){
            l1length++;
            tmp1 = tmp1.next;
        }
        tmp1 = l2.next;
        while (tmp1!=null){
            l2length++;
            tmp1 = tmp1.next;
        }

        ListNode large = null;
        ListNode small = null;
        if(l1length>=l2length){
            large = l1;
            small = l2;
        }else{
            large = l2;
            small = l1;
        }
        sum = new ListNode((large.val+small.val)%10);
        int step = (large.val+small.val)/10;
        sum.next = new ListNode(step);
        while(large.next!=null){

            if (small.next!=null){
                sum.next = new ListNode((large.next.val+small.next.val+step)%10);
                step = (large.val+small.val+step)/10;
                small = small.next;
            }else{
                sum.next = new ListNode((large.next.val+step)%10);
                step = (large.val+step)/10;

            }
            large = large.next;


        }



        return sum;

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
