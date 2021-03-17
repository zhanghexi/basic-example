package org.basic.thread.waitnotify;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname Producer
 * @Description
 * @Author Lucien
 * @Date 2021/3/17
 * @Version 1.0
 */
public class ProducerThread implements Runnable {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @SneakyThrows
    @Override
    public void run() {
        //获取 lock对象监视器 并加锁
        synchronized (WaitNotifyDemo.lock) {
            /*当条件不满足时,继续wait，同时只是暂时释放了lock对象上的锁，并将当前对象防止到对象的等待队列中*/
            while (WaitNotifyDemo.flag) {
                System.out.println("线程 " + Thread.currentThread().getName()
                        + " flag is true..." + format.format(new Date()));
                WaitNotifyDemo.lock.wait();
            }
            /*当条件满足时，完成工作*/
            System.out.println("线程 " + Thread.currentThread().getName()
                    + " flag is true..." + format.format(new Date()));
        }
    }
}