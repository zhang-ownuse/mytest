package com.zhangbin;

import java.util.HashMap;
import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int x =0;
        int y=0;
        int fightA = 0;
        int fightB = 0;
        HashMap<Integer,Integer> A = new HashMap<>();
        HashMap<Integer,Integer> B = new HashMap<>();
        for (int i = 0; i < n; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            A.put(y,x);
        }for (int i = 0; i < m; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            B.put(y,x);
        }
        for (Integer sum:A.keySet()){
            if (sum >= k){
                fightA += sum*A.get(sum);
            }
        }
        for (Integer sum:B.keySet()){
            if (sum >= k){
                fightB += sum*B.get(sum);
            }
        }
        StringBuilder result = new StringBuilder();
        if (fightA> fightB){
            result.append('A');
        }else {
            result.append('B');
        }
        System.out.println(fightA +" " + fightB);
        System.out.println(result.toString());
    }
}
