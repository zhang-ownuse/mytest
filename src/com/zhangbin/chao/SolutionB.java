package com.zhangbin.chao;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SolutionB {
    static class AllocatedMemory {
        PriorityQueue<Node> temp = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.index - o2.index;
            }
        });
        AllocatedMemory() {

        }

        // 返回分配的内存首地址(string)，失败返回字符串 "error"
        String request(int size) {
            // 在此补充你的代码
            //添加完成
            int nowSize;
            int now = 0;
            boolean flag = false;
            for (Node node:temp
                 ) {
                nowSize = node.index - now;

                if (nowSize >= size){
                    temp.add(new Node(now,size));
                    flag = true;
                    break;
                }
                now = node.index + node.count;
            }
            if (now == 0){//代表从来没分配过
                temp.add(new Node(now,size));
                flag = true;
            }
            if (flag == false){
                if (100-now >= size){
                    temp.add(new Node(now,size));
                    flag = true;
                }
            }
            if (flag == true){
                return now+"";
            }else {
                return "error";
            }
        }

        // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
        boolean release(int startAddress) {
            boolean flag = false;
            for (Node node: temp
                 ) {
                if (startAddress == node.index){
                    temp.remove(node);
                    flag = true;
                    break;
                }
            }
           return flag;
        }
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        AllocatedMemory allocatedMemory = new AllocatedMemory();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(cin.nextLine());
        String[][] ins = new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i] = cin.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST")) {
                System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
            } else {
                boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }

        cin.close();
    }

    static class  Node{
        int index;//表示位置
        int count;//代表总数

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

}
