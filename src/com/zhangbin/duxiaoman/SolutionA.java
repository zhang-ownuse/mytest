package com.zhangbin.duxiaoman;

import java.util.Scanner;

public class SolutionA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() == 5){
            System.out.println("horse");
        }else {
            if (s.charAt(0) == 'p'){//第一个是p 可能是pig 或者是c的第一个错了
                if (s.charAt(1) == 'a' && s.charAt(2) == 't'){
                    System.out.println("cat");
                }else {
                    System.out.println("pig");
                }
            }else {//是c或者其他
                if (s.charAt(1) == 'i' && s.charAt(2) == 'g'){
                    System.out.println("pig");
                }else {
                    System.out.println("cat");
                }
            }
        }
    }
}
