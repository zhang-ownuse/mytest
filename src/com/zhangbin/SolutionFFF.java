package com.zhangbin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SolutionFFF {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tar = new int[n][2];
        int num  = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            index = sc.nextInt();
            tar[i][0] = num;
            tar[i][1] = index;
        }
        ArrayList<Integer> temp = new ArrayList<>();//用来存储数量
        boolean[] vis = new boolean[n];
        num = 0;
        LinkedList<int[]> res = new LinkedList<>();
        while (true){
            int max = -1;//假设身高没有负数
            //找出最大的数字
            for (int i = 0; i < n; i++) {
                if (vis[i] == false && max == -1){
                    max = i;
                }else if (max == -1 ) {
                    continue;
                }
                if (vis[i] == false && tar[max][0] < tar[i][0]){
                    max = i;

                }
            }
            if (max == -1){
                break;
            }
            vis[max] = true;
            temp.add(max);
            //找出所有的最大值
            for (int i = 0; i < n; i++) {
                if (tar[i][0] == tar[max][0] && vis[i] == false){
                    temp.add(i);
                    vis[i] = true;
                }
            }
            //把所有的最大值放进去
            for (Integer integer : temp){
                res.add(tar[integer][1],tar[integer]);
            }
            temp.clear();
        }

        for (int[] result: res
             ) {
            System.out.println(result[0] + "----------" +result[1]);
        }

    }
}
