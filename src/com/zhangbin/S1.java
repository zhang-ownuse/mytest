package com.zhangbin;

import java.util.HashMap;
import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> res = new HashMap<>();
        int[] target = new int[6];
        for (int i = 0; i < 1; i++) {
            target[i] = sc.nextInt();
        }
        int num1 = 0;
        int num2 = 0;
        boolean flag = false;
        for (int i = 0; i < 1; i++) {
            if (num1 == 0||num1 == target[i]) {
                num1 = target[i];
                Integer integer = res.get(num1);
                if (integer == null){
                    res.put(num1, 1);
                }else {
                    res.put(num1, integer++);
                }
            }else if (num2 == 0||num2 == target[i]){
                num2 = target[i];
                Integer integer = res.get(num2);
                if (integer == null){
                    res.put(num2, 1);
                }else {
                    res.put(num2, integer++);
                }
            }else {
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("NO");
        }else {
            if (res.get(num1) ==res.get(num2)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
