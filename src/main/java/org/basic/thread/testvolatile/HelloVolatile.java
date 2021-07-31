package org.basic.thread.testvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 成员变量对多线程的可见性
 * @Author : Lucien
 * @Date Date : 2021-05-25 0:36
 * @Version V1.0
 */
public class HelloVolatile {

    private static volatile boolean running = true;

    private static void m() {
        System.out.println("m start....");
        while (running) {
            /*这里println由于用到了 synchronized 关键字，所以即使没有 volatile 也会保持可见性*/
            /*System.out.println("Hello...");*/
        }
        System.out.println("m end....");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(HelloVolatile::m, "t1").start();
        TimeUnit.SECONDS.sleep(1);
        running = false;
    }
}