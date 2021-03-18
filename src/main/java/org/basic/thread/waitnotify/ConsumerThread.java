package org.basic.thread.waitnotify;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname ConsumerThread
 * @Description
 * @Author Lucien
 * @Date 2021/3/17
 * @Version 1.0
 */
public class ConsumerThread implements Runnable {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @SneakyThrows
    @Override
    public void run() {
        /*获取对象的监视器*/
        synchronized (WaitNotifyDemo.lock) {
            //获取对象上的锁，然后通知等待队列中的所有对象,但这个时候不会释放锁
            System.out.println("线程 " + Thread.currentThread().getName()
                    + " 持有锁..." + format.format(new Date()));
            //调用该方法后,将会把所有等待队列中的线程全部移动到同步队列中
            WaitNotifyDemo.lock.notifyAll();
            WaitNotifyDemo.flag = false;

            Thread.sleep(1000);
        }
        //再次加锁
        synchronized (WaitNotifyDemo.lock) {
            System.out.println("线程 " + Thread.currentThread().getName()
                    + " 再次持有锁..."
                    + format.format(new Date()));
            Thread.sleep(1000);
        }
    }
}