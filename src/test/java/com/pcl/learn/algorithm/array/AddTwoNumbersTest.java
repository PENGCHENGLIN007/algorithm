package com.pcl.learn.algorithm.array;

import org.junit.Test;

public class AddTwoNumbersTest {
    @Test
    public void listnodeTest(){
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        ListNode data = new ListNode(1);
        cursor.next = data;
        cursor = data;
        ListNode data2 = new ListNode(2);
        cursor.next = data2;
        cursor = data2;
        ListNode data3 = new ListNode(3);
        cursor.next = data3;
        cursor = data3;

        do {
            System.out.print(root.next.val);
            root.next = root.next.next;
        }
        while (root.next!=null);

    }


}