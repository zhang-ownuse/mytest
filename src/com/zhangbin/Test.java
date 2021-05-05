package com.zhangbin;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void printJ(){
        lock.lock();
        try {
            while (num %2 == 0){
                condition.await();
            }
            Thread.sleep(3000);
            System.out.println(num+Thread.currentThread().getName());
            num++;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printO(){
        lock.lock();
        try {
            while (num %2 == 1){
                condition.await();
            }
            Thread.sleep(3000);
            System.out.println(num+Thread.currentThread().getName());
            num++;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
