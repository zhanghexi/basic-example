package org.basic.thread.daemon;

import java.io.IOException;

/**
 * @Classname MyDaemonThread
 * @Description 通常情况下，我们使用Thread 创建的线程在默认情况下都属于用户线程
 * 当在启动线程之前, 执行thread.setDaemon(true)时, 线程会变成守护线程
 * @Author Lucien
 * @Date 2021/3/17
 * @Version 1.0
 */
public class MyDaemonThread {

    public static void execute() {
        for (int i = 0; ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(() -> execute());
        /*将新建的线程设为守护线程
         * 这里主线程是用户线程，守护线程每隔一秒打印一个i值，直到主线程输入任意一个字符推出*/
        thread.setDaemon(true);
        /*setDaemon方法必须在start方法之前，不然会报错*/
        thread.start();

        System.in.read();
    }
}