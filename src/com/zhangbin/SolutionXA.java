package com.zhangbin;

public class SolutionXA {
        public static void main(String[] args) {
            int[] a = {4,1,2,3,5,6};

            int j = 0;
            for (int i = 1; i < a.length; i++) {
                int num = a[i];//待插入的数
                j = i - 1;  //待插入的前一个数
                if (a[i] % 2 == 1) {
                    while (j >= 0 && a[j] % 2 == 0) {
                        a[j + 1] = a[j];
                        j--;
                    }
                    a[j + 1] = num;
                }
            }
            for (int i : a) {
                System.out.println(i);
            }

        }


}
