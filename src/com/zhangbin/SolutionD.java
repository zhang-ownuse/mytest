package com.zhangbin;

public class SolutionD {
    public static void main(String[] args) {
        SolutionD test = new SolutionD();
        int i = test.maxCoins1(new int[]{3, 2, 5});
        System.out.println(i);
    }
    public int maxCoins1(int arr[]){
        if (arr == null || arr.length == 0){
            return 0;
        }
        if (arr.length == 1){
            return arr[0];
        }
        int N = arr.length;
        int[] target = new int[N + 2];
        target[0] = 1;
        target[N + 1] = 1;
        for (int i = 1; i <= N ; i++) {
            target[i] = arr[i-1];
        }
        return process(target,1,N);
    }

    private int process(int[] target, int L, int R) {
        if (L ==R){
            return target[L-1] * target[L] * target[L + 1];
        }
        int max = Math.max(target[L-1]*target[L] * target[R+1]+ process(target,L + 1,R),target[L-1]*target[R] * target[R+1]+ process(target,L ,R-1));
        for (int i = L + 1; i < R; i++) {
            max = Math.max(max,target[L-1]*target[i] * target[R+1]+ process(target,L ,i-1)+ process(target,i+1 ,R));
        }
        return max;
    }

}
