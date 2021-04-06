package org.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Classname Demo
 * @Description
 * @Author Lucien
 * @Date 2021/3/30
 * @Version 1.0
 */
public class Demo {

    static volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("start");
            while (!flag) {

            }
            System.out.println("end");
        }).start();
        /*这里面不涉及任何重排序和可见性问题*/
        TimeUnit.SECONDS.sleep(5);
        flag = true;
    }
}