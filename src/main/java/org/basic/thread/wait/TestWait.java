package org.basic.thread.wait;

/**
 * @Classname TestWait
 * @Description
 * @Author Lucien
 * @Date 2021/3/25
 * @Version 1.0
 */
public class TestWait {

    public static void main(String[] args) {
        Object ob = new Object();
        WaitThread wt = new WaitThread(ob);

        new Thread(() -> {
            wt.name();
        }, "t1").start();

        new Thread(() -> {
            wt.name();
        }, "t2").start();

        synchronized (ob) {
            ob.notifyAll();
        }
    }
}
