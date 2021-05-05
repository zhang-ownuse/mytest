package com.zhangbin;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> res = new ArrayList<>();

        String mingling = null;
        int num =0;//表示编号
        int target= 0;//表示分数
        String n = sc.nextLine();
        int cishu = Integer.valueOf(n);
        for (int i = 0; i < cishu; i++) {
            String s = sc.nextLine();
            String trim = s.trim();
            String[] split = trim.split(" ");
            if (split[0].equals("query")){
                int l = 0;
                Collections.sort(res, new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        int l = o2.socre - o1.socre;
                        if (l == 0){
                            l = o1.num - o2.num;
                        }
                        return l;
                    }
                });
                Iterator<Node> iterator = res.iterator();
                while (iterator.hasNext()){

                    Node next = iterator.next();
                    System.out.println(next.num);
                    l++;
                    if (l == 10){
                        break;
                    }
                }
                if ( l == 0){
                    System.out.println("null");
                }

            }else{
                Node node = new Node(Integer.valueOf(split[1]),Integer.valueOf(split[2]));
                for (Node test :res
                     ) {
                    if (test.num == node.num){
                        res.remove(test);
                        node.socre += test.socre;
                        break;
                    }
                }
                res.add(node);
            }
        }
    }
    public static class  Node{
        public int num;
        public int socre;

        public Node(int num, int socre) {
            this.num = num;
            this.socre = socre;
        }
    }
}
