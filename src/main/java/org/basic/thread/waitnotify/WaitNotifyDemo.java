package org.basic.thread.waitnotify;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname WaitNotifyDemo
 * @Description wait(), notify(), notifyAll()不属于Thread类, 而是属于Object基础类
 * 也就是说每个对象都有wait(),notify(),notifyAll()的功能,因为每个对象都有锁,锁是每个对象的基础
 * wait导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法,或被其他线程中断
 * wait只能由持有对像锁的线程来调用
 * notify唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程(随机)。
 * 直到当前的线程放弃此对象上的锁，才能继续执行被唤醒的线程。同Wait方法一样，notify只能由持有对像锁的线程来调用
 * notifyall也一样，不同的是notifyall会唤配所有在此对象锁上等待的线程
 * 参考文献：https://www.jb51.net/article/37868.htm
 * https://www.jianshu.com/p/4cc51d2408f3?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
 * @Author Lucien
 * @Date 2021/3/17
 * @Version 1.0
 */
@Data
public class WaitNotifyDemo {

    public static boolean flag = true;
    public static Object lock = new Object();

    @SneakyThrows
    public static void main(String[] args) {
        Thread waitThread = new Thread(new ProducerThread(), "WaitThread");
        waitThread.start();
        Thread.sleep(1000);

        Thread notifyThread = new Thread(new ConsumerThread(), "NotifyThread");
        notifyThread.start();
    }
}