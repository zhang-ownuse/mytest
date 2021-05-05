package com.zhangbin;

import sun.awt.windows.ThemeReader;

public class Solution5 {
    public static void main(String[] args) {
        Test test = new Test();
        new Thread(()->{
            while (true) {
                test.printJ();
            }
        },"AAAA").start();
        new Thread(()->{
            while (true) {
                test.printO();
            }
        },"BBB").start();
        while (Thread.activeCount()>2){
            Thread.yield();
        }
    }
}
