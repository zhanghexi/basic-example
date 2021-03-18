package org.basic.thread.atomic;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicIntegerTest
 * @Description Integer线程安全测试类
 * 最简单模拟多线程并发抢票的场景，一共50张票(atomicInteger初始值为50，抢票过程中依次递减)，200个线程并发去抢
 * @Author Lucien
 * @Date 2021/3/19
 * @Version 1.0
 */
public class AtomicIntegerTest {

    /**
     * 全局共享变量(加volatile并不能保证count结果最后是10000
     * volatile只保证线程之间对成员变量修改的可见性，不能保证原子性)
     */
    /*public static volatile int count = 0;*/

    private static int size = 50;
    private static AtomicInteger atomicInteger = new AtomicInteger(size);

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(200);
        for (int i = 0; i < size; i++) {
            executor.execute(() -> {
                //自减并返回当前值
                int increment = atomicInteger.decrementAndGet();
                System.out.println("线程 " + Thread.currentThread().getName()
                        + " 的count值等于 " + increment);
            });
            /*try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        executor.shutdown();
    }
}