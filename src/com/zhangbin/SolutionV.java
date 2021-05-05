package com.zhangbin;

import java.util.Scanner;

public class SolutionV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        getRes(res);
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
    public static void getRes(int[] arr){
        int pos = -1;//用来去标记第一个偶数的位置,往后面接着找的地方
        int index = -1;//用来标志第一个偶数的位置方便后面进行替换
        int ji = pos;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && index == -1){//第一次找到偶数
                index = i;
                ji = getJi(arr,index);
                i = ji;
                index += 1;
            }else if (arr[i] % 2 == 0){
                ji = getJi(arr,index);
                i = ji ;
                index += 1;
            }
        }
    }

    private static int getJi(int[] arr, int i) {
        int j = 0;
        for (j = i; j < arr.length; j++) {
            if (arr[j] % 2 == 1){//代表我这里找到的是基数,往前面冒泡
                for (int k = j; k >i ; k--) {
                    int temp = arr[k];
                    arr[k] = arr[k-1];
                    arr[k-1] = temp;
                }
                break;
            }
        }
        return j -1;
    }
}
