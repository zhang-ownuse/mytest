package com.zhangbin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeToPrint {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void inOrderRecur(Node node){
        if (node == null)
            return ;
        inOrderRecur(node.left);
        System.out.println(node.val);
        inOrderRecur(node.right);
    }
    public static void preOrderUnRecur(Node node){
        if (node != null){
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()){
                node = stack.pop();
                System.out.println(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
        }
    }

    public static void inOrderUnRecur(Node node){
        if (node != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || node != null){
                //如果这个点不空的话就先去看左边，
                if (node != null){
                    stack.push(node);
                    node = node.left;
                }else {//如果这个点事空的话，就直接弹回去来它的那个点，就是它的父节点,然后换到右节点进行操作
                    node = stack.pop();
                    System.out.println(node.val);
                    node = node.right;
                }

            }
        }
    }

    public static void posOrderRecur(Node node){
        if (node == null)
            return ;
        posOrderRecur(node.left);
        posOrderRecur(node.right);
        System.out.println(node.val);
    }
    public static void posOrderUnRecur(Node node){
        if (node == null){
            return ;
        }
        //实现的思想就是通过二个栈，前序遍历是中左右，但是先压左边，就是右边先出来，是中右左，正好反过来就是左右中
        Stack<Node> stack1 = new Stack<>();//用来存储第一个栈
        Stack<Node> stack2 = new Stack<>();//用来存储第二个栈
        stack1.push(node);
        while (!stack1.isEmpty()){
            Node pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null){
                stack1.push(pop.left);
            }
            if (pop.right!=null){
                stack1.push(pop.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }

    }


    public static void showInLayer(Node node){
        if (node == null){
            return ;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(node);
        while (!queue.isEmpty()){
            Node pop = queue.pollLast();
            System.out.println(pop.val);
            if (pop.left != null){
                queue.push(pop.left);
            }
            if (pop.right != null){
                queue.push(pop.right);
            }
        }
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
//        inOrderRecur(head);
//        posOrderRecur(head);
//        posOrderUnRecur(head);
        showInLayer(head);
    }

}
