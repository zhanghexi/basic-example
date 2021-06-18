package org.basic.thread.testsynchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author : Lucien
 * @Date Date : 2021-06-02 16:32
 * @Version V1.0
 */
public class SyncTest {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end...");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end...");
    }

    public static void main(String[] args) {
        SyncTest st = new SyncTest();
        new Thread(st::m1, "t1").start();
        new Thread(st::m2, "t2").start();
    }
}
