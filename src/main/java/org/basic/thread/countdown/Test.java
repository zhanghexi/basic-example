package org.basic.thread.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : Lucien
 * @version V1.0
 * @Description: CountDownLatch倒计时器，控制线程等待，直到倒计时器归零再继续执行
 * @date Date : 2021/04/11
 */
public class Test {

    public static final int threadNum = 10;

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(threadNum);

        /*创建一个固定大小的线程池*/
        ThreadPoolExecutor executor = new ThreadPoolExecutor(threadNum,
                20,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        /*添加线程到线程池*/
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new Person(latch, (i + 1)));
        }
        System.out.println("开始等待全员签到...");

        try {
            /*等待所有线程执行完毕*/
            latch.await();
            System.out.println("签到完毕，开始吃饭...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}