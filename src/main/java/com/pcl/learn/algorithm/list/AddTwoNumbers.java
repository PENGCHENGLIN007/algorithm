package com.pcl.learn.algorithm.list;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pengchenglin
 * @create 2020-06-01 20:24
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);

        ListNode l2 = new ListNode(1);

        ListNode result = addTwoNumbers(l1,l2);
        do {
            System.out.print(result.val);
            result = result.next;
        }
        while (result!=null);

    }

    /**
     * 官方答案
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.92%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了94.26%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersBest(ListNode l1, ListNode l2){
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int l1val = l1!=null?l1.val:0;
            int l2val = l2!=null?l2.val:0;
            int sumVal = l1val+l2val+carry;
            carry = sumVal/10;
            ListNode newNode = new ListNode(sumVal%10);
            cursor.next = newNode;
            cursor = newNode;

            if(l1!=null){ l1 = l1.next;}
            if(l2!=null){ l2 = l2.next;}
        }

        return root.next;
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.92%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了94.26%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        if(l1.val==0 && l2.val==0 && l1.next==null && l2.next==null){
            sum = new ListNode(0);
            return sum;
        }
        if(l1.val==0 && l1.next==null){
            return l2;
        }
        if(l2.val==0 && l2.next==null){
            return l1;
        }
        ListNode tmp1 = l1.next;
        int l1length = 1;
        int l2length = 1;
        int length = 0;
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
            length = l1length;
        }else{
            large = l2;
            small = l1;
            length = l2length;
        }
        sum = new ListNode((large.val+small.val)%10);
        int step = (large.val+small.val)/10;

        if(large.next==null && step!=0){
            sum.next = new ListNode(step);
        }
        boolean jump = false;
        while(length>1){
            if(jump){
                break;
            }
            int newVal;

            if (small.next!=null){
                newVal = (large.next.val+small.next.val+step)%10;
                step = (large.next.val+small.next.val+step)/10;
                small = small.next;
                large = large.next;
            }else if (large.next!=null){
                newVal = (large.next.val+step)%10;
                step = (large.next.val+step)/10;
                large = large.next;
            }else{
                if(step==0){
                    break;
                }
                newVal = step;
                jump = true;

            }
            addNode(sum,newVal);
            if(large.next==null){
                length++;
            }
            length--;

        }

        return sum;

    }
    public static void addNode(ListNode sum,int val){
        if(sum.next==null){
            sum.next = new ListNode(val);
        }else{
            addNode(sum.next,val);
        }
    }
}

