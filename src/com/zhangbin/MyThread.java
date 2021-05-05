package com.zhangbin;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable come in ..."+Thread.currentThread().getName());
        // 模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){

        }
        return 1024;
    }
}