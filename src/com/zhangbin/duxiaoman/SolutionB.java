package com.zhangbin.duxiaoman;

import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        char a = '%';//用来标记相同的字母
        char b = '%';
        int index = -1;
        boolean flag = false;
        for (int i = 0; i < Integer.valueOf(n); i++) {
            String target = sc.nextLine();
            char[] chars = target.toCharArray();
            //怎么样把它给截成3个3个的这种。
            if (target.length() % 3 != 0){
                System.out.println("No");
                continue;
            }
            for (int j = 0; j < target.length() - 3; j++) {
                //把1，2位置不同的地方标出来，记住相同的位置的字符，如果没有不同则由第二个和第三个比较 这样
                if (index == -1){
                    if (chars[j] == chars[j + 3]){
                        if (a !='%'){
                            a = chars[j];
                            continue;
                        }
                        if (b != '%'){
                            b = chars[j];
                            continue;
                        }
                        a = '%';
                        b = '%';
                    }else {
                        index = j % 3;//找出了不同的位置
                        continue;
                    }
                }
                //在后面进行比较
                if (j % 3 == index){
                    continue;
                }
                if (chars[j] != chars[j + 3]){
                    flag = true;
                }
            }
            if (flag){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
            flag = false;
        }
    }
}
