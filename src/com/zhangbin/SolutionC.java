package com.zhangbin;

import java.util.*;

public class SolutionC {
    public static class  Node{
        public int num;
        int sc;
        public Node(int num, int s) {
            this.num = num;
            this.sc = s;
        }
    }

    public static void main(String[] args) {

//        Collections.sort(res, new Comparator<Object>() {
//        });
        PriorityQueue<Node> test = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int l = o2.sc - o1.sc;
                if (l == 0){
                    l = o1.num - o2.num;
                }
                return l;
            }
        });
        test.add(new Node(1,10));
        test.add(new Node(2,11));
        test.add(new Node(3,11));

        for (Node res: test
        ) {
            System.out.println(res.num + " -----" +  res.sc);
        }
        System.out.println("+++++++++++++++++++++++");
        Node node = new Node(1, 20);
//        for (Node res: test
//            ) {
//                if (res.num == node.num){
////                    node.sc += res.sc;
//                    test.remove(res);
//                    break;
//                }
//            }
        test.remove();
//        test.add(node);
        test.add(new Node(4,15));
//
        Iterator<Node> iterator = test.iterator();
        while (iterator.hasNext()){
            Node next = iterator.next();
            System.out.println(next.num+ " -----" + next.sc);
        }
        System.out.println("=============");
        Node remove = test.remove();
        System.out.println(remove.num+ " -----" + remove.sc);
         remove = test.remove();
        System.out.println(remove.num+ " -----" + remove.sc);
         remove = test.remove();
        System.out.println(remove.num+ " -----" + remove.sc);
        System.out.println("------------------------------------------------------------------");
        TreeMap<Integer,Integer> test1 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        test1.put(1,10);
        test1.put(2,5);
        test1.put(3,15);
        for (Integer res :test1.keySet()
             ) {
            System.out.println(res + "--"+test1.get(res));
        }
    }



}
