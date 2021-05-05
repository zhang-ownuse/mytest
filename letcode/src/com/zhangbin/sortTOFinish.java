package com.zhangbin;

public class sortTOFinish {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 6, 3};
        mergeSort(a);
        show(a);
    }

    public static void bubbleSort(int[] arr) {
        //每次都要进行类型判断防止非空操作和无效的比较操作
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t;
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length - 1; i++) {

            for (int j = i + 1; j > 0 && arr[j - 1] > arr[j]; j--) {
                int t;
                t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
            }
        }
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int t;
            t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        //递归先找出出口
        if (l == r) {//只剩下自己了一定是有序的
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] hlep = new int[r - l + 1];//暂存数组
        int i = 0;//转移数组
        int p1 = l;//左指针标记左边的数组的开头
        int p2 = mid + 1;//右指针标记右边的开头
        while (p1 <= mid && p2 <= r) {//进行比较归并
            hlep[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {//剩下的加入
            hlep[i++] = arr[p1++];
        }
        while (p2 <= r) {//剩下的加入
            hlep[i++] = arr[p2++];
        }
        //填回原来的数组中
        for (i = 0; i < r - l + 1; i++) {
            arr[l + i] = hlep[i];
        }
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
