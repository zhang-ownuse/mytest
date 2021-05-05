package com.zhangbin;

import java.util.List;
import java.util.Stack;

public class MergeTwoSortedLists {
}

class ListNode {
        int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static void main(String[] args) {
//        ListNode one10 = new ListNode(10);
//        ListNode one9 = new ListNode(9,one10);
//        ListNode one8 = new ListNode(8,one9);
        ListNode one7 = new ListNode(7);
        ListNode one6 = new ListNode(6,one7);
        ListNode one5 = new ListNode(5,one6);
        ListNode one4 = new ListNode(4,one5);
        ListNode one3 = new ListNode(3,one4);
        ListNode one2 = new ListNode(2,one3);
        ListNode one1 = new ListNode(1,one2);


        ListNode two2 = new ListNode(2);
        ListNode two1 = new ListNode(1,two2);
//        show(one1);
//        show(two1);
//        ListNode listNode = mergeTwoLists(one1, two1);
//        show(listNode);

//        deleteDuplicates(one1);
//        ListNode listNode = swapPairs(two1);
//        ListNode listNode = addTwoNumbers(one1, two1);
//        show(listNode);

//        boolean palindrome = isPalindrome(one1);
//        System.out.println(palindrome);
//        ListNode reverse = reverse(two3,two1);
//        show2(reverse);
//        ListNode[] listNodes = splitListToParts(one1,5);
//        show3(listNodes);
        ListNode listNode = oddEvenList(one1);
        show(listNode);

    }
    //合并链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;

            }else {
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }

        }
        while (l1 != null){
            tail.next= l1;
            l1 = l1.next;
            tail = tail.next;
        }
        while (l2 !=null){
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        return head.next;
    }

    //删除重复链表
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = head;
        head = head.next;
        while (head != null){
//            如果相等进行去除
            if (pre.val == head.val){
                pre.next = head.next;
                head = head.next;
            }else{
                pre = head;
                head = head.next;
            }
        }
        return newHead.next;
    }

    //删除倒数第n个
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = head;
        while (n-- > 0){
            newHead = newHead.next;
        }
//        走到了空代表n正好是这个队列的长度
        if (newHead == null){
            return head.next;
        }
        ListNode slowNode =head;
        //其实就是让它先走整个长度的n步剩下的走到null的步数就是从头往前走的步数
        while (newHead.next != null){
            slowNode = slowNode.next;
            newHead = newHead.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }


    //交换链表中的相邻节点
    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null){
            return  head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head.next;
        ListNode firstHead =head;
        ListNode secondHead =head.next;
        ListNode pre = secondHead.next;
        ListNode before = null;

        while (firstHead!=null && secondHead != null){
            ListNode t = null;
            t = firstHead;
            firstHead = secondHead;
            firstHead.next = t;
            secondHead = t;
            secondHead.next = null;
//            secondHead.next = pre;
            before = secondHead;
            if (pre != null) {
                firstHead = pre;
                secondHead = pre.next;
                if (secondHead != null){
                    pre = secondHead.next;
                    before.next = secondHead;
                }else{
                    before.next = firstHead;
                }
            }else{
                firstHead = null;
            }


//            System.out.println(firstHead.val);
        }
        //一个为奇数的一个为偶数的一个为换之前的下一个的
        return newHead.next;
    }

    //两数相加 II
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //先把二个数都压入栈中，对栈进行操作
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        //l1压入栈中
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        //l2压入栈中
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode();
        int flag = 0;
        int result;
        //直接进行叠加
        while ( !stack1.isEmpty() || !stack2.isEmpty() || flag != 0){
            int x = stack1.isEmpty()?0:stack1.pop();
            int y = stack2.isEmpty()?0:stack2.pop();
            result = x + y + flag;
            flag = 0;
            if (result >= 10){
                result %= 10;
                flag = 1;
            }
            ListNode newNode = new ListNode();
            newNode.val = result;
            newNode.next = head.next;
            head.next = newNode;
        }

        return head.next;
    }

    //回文链表
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast.next != null){
            //快指针走二步
            if (fast.next.next != null && fast.next != null){
                fast = fast.next.next;
            }else {
                break;
            }
            //慢指针走一步
            slow = slow.next;
        }
        ListNode end = slow.next;
        slow.next = null;
        if (fast.next != null){
            fast = fast.next;
        }

       //把尾部的进行反转
        ListNode reverse = reverse(fast, end);

        while (head != null){
           if (head.val != reverse.val)
               return false;
           head = head.next;
           reverse = reverse.next;
        }

        return true;
    }
    public static ListNode reverse(ListNode head,ListNode end){
        if (end == head ){
            return head;
        }
        ListNode pre = null;
        ListNode now = end;
        ListNode next = null;
        while (now!= null){
            next = now.next;
            now.next =pre;
            pre = now;
            now = next;
        }
        return head;
    }


    public static ListNode[]  splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int length = 0;
        //统计长度
        while (cur != null){
            length++;
            cur = cur.next;
        }
        ListNode[] results = new ListNode[k];
        //对长度进行截取
        int size = length/k;
        int random = length % k;
        cur = root;
        for (int i = 0 ; i < k && cur != null;i++){
            results[i] = cur;
            int curSize = random-- > 0 ?1:0;
            for (int j = 0;j < (size + curSize ) -1;j++){
                cur = cur.next;
            }
                ListNode next = cur.next;
                cur.next = null;
                cur = next;

        }
        return results;

    }

    public static void show(ListNode l1){
        while (l1!=null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
    public static void show2(ListNode l1){
       for (int i = 0;i<3;i++){
           System.out.println(l1.val);
           l1 = l1.next;
       }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
//        ListNode first = head;
        ListNode second = head.next;
        ListNode firstNow = second.next;
        ListNode now = second;
        ListNode pre = head;
        ListNode next;
        //分开进行处理
        while (firstNow != null && now !=null){
            next =firstNow.next ;
            pre.next = firstNow;
            now.next = next;
            now = next;
            pre = pre.next;
            if (now != null) {
                firstNow = now.next;
            }else {
                firstNow = null;
            }
        }
        //拼接
        pre.next = second;
        return head;
    }

    public static void show3(ListNode[] l1){
        int length = l1.length;
        for (int i = 0; i < length; i++) {
            while (l1[i] != null){
                System.out.println(l1[i].val);
                l1[i] = l1[i].next;
            }
            System.out.println("-----------------");
        }
    }
}



