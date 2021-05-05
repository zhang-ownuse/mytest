package com.zhangbin;

public class QuickSort {
    public static void quickSort(int[] array,int l,int r){
        if (array.length < 1){
            return ;
        }
        int smallIndex = partition(array,l,r);
        if (smallIndex > l){
            partition(array,l,smallIndex - 1);
        }
        if (smallIndex < r){
            partition(array,smallIndex + 1,r);
        }
    }

    private static int partition(int[] array, int l, int r) {
        //直接用最后一个数来当做判断好了
        int temp = array[r];
        while (l < r){
            while (l < r && array[l] > temp){
                l++;
            }
            if (l < r){
                array[r] = array[l];
            }
            while (l <r && array[r] < temp){
                r--;
            }
            if (l < r){
                array[l] = array[r];
            }
        }
        array[l] = temp;
        return l;
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,2,5,6,4,3};
        quickSort(res, 0, res.length - 1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
