package com.zhangbin;

public class MergesortSolve {
    public static void main(String[] args) {
        int[] a = {1,3,2,3,1};
        int i = mergeSort(a, 0, a.length - 1);
        System.out.println(i);
        show(a);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 2);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int result = 0;
        int i = 0;//标记help的长度
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            //左右二边都是有序的，如果右边的值大于当前的值，代表从这个数以后的值都大于这个值，而且右边的本来就在左边的右边
            result += arr[p1] > arr[p2] ?   (mid - p1 + 1) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while ( p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
        return result;
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
