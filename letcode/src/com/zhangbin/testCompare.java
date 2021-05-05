package com.zhangbin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class testCompare {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(3);

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;//这样写  返回是负数第一个在前面 是正数第二个在前面 返回就是升序
                return  o2 -o1;//这样写 返回是正数 第二个大 第二个在前
                //这样记吧 升序就第一个在前 降序就第二个在前
            }
        });
        System.out.println(arrayList);
    }
}
