package com.zhangbin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> nums = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int k = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums.put(i,sc.nextInt());
        }

        while (k >0){
            int min = Integer.MAX_VALUE,index = 0;
            for (Integer target: nums.keySet()
                 ) {
                if (nums.get(target) < min){
                    min = nums.get(target);
                    index = target;
                }
            }
            nums.put(index,min+k);
            System.out.println(index + 1);
            k--;
        }
    }
}
