package org.basic.thread.wait;

import java.util.concurrent.TimeUnit;

/**
 * @Classname WaitThread
 * @Description
 * @Author Lucien
 * @Date 2021/3/25
 * @Version 1.0
 */
public class WaitThread {

    /**
     * 获得锁的对象
     */
    private Object ob;

    public WaitThread(Object ob) {
        this.ob = ob;
    }

    public void name() {
        synchronized (ob) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "当前循环值 = " + i);
                if (i == 5) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 线程等待中......");
                        ob.wait();
                        System.out.println(Thread.currentThread().getName() + " 线程已唤醒......");

                        System.out.println("睡5秒后执行剩余部分......");
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}