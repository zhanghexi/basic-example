package org.basic.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author : Lucien
 * @Date Date : 2021-04-25 11:34
 * @Version V1.0
 */
public class AtomicIntegerTest2 {

    private static final int THREADS_CONUT = 20;
    /*public static volatile int count = 0;*/
    /**
     * 利用AtomicInteger保证成员变量在并发时的原子性
     */
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }
}