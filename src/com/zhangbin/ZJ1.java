package com.zhangbin;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ZJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> nodes = new ArrayList<>();
        Stack<Integer> res = new Stack<>();
        for (int i = 0; i < 4; i++) {
            int day = sc.nextInt();
            int num = sc.nextInt();
            nodes.add(new Node(i,day,num));
        }
        while (nodes.size() != 0){
            int target = 0;
            for (Node temp: nodes
                 ) {

            }
        }

    }
    public static class Node{
        int index;
        int day;
        int num;

        public Node(int index,int day, int num) {
            this.day = day;
            this.num = num;
        }
    }
}
