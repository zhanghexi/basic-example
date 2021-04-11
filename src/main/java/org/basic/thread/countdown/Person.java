package org.basic.thread.countdown;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author : Lucien
 * @version V1.0
 * @Description: TODO
 * @date Date : 2021/04/11
 */
@AllArgsConstructor
public class Person implements Runnable, Serializable {

    private CountDownLatch countDownLatch;
    private int index;

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Person " + index + " 签到");
        /*线程执行完毕，计数器减一*/
        countDownLatch.countDown();
    }
}