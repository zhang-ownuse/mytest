package com.zhangbin;

import java.util.Arrays;

public class GuiBingPaiXu {
    public static void MergeSort(int[]array,int l,int r){
        if (l < r) {
            int mid = (r + l ) / 2;
            MergeSort(array, l, mid);
            MergeSort(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }

    private static void merge(int[] mergeSort, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int next = mid+1;
        int start = l;
        int index = 0;
        while (l <= mid && next <= r){
            if (mergeSort[l] >= mergeSort[next]){
                temp[index++] = mergeSort[l++];
            }else {
                temp[index++] = mergeSort[next++];
            }
        }
        while (l <= mid){
            temp[index++] = mergeSort[l++];
        }
        while (next <= r){
            temp[index++] = mergeSort[next++];
        }
        for (int i = 0; i < temp.length; i++) {
            mergeSort[start++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,2,5,6,4,3};
        MergeSort(res, 0, res.length - 1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
