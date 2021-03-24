package org.basic.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @Classname Thread_Test3
 * @Description
 * @Author Lucien
 * @Date 2021/3/23
 * @Version 1.0
 */
public class Thread_Test3 implements Runnable {

    private /*volatile*/ int count = 10000;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " 的 count = " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread_Test3 t3 = new Thread_Test3();
        for (int i = 0; i < 10000; i++) {
            new Thread(t3, "THREAD-" + (i + 1)).start();
        }
    }
}