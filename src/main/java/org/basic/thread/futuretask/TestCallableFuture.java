package org.basic.thread.futuretask;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @Author : Lucien
 * @Date Date : 2021-05-27 16:06
 * @Version V1.0
 */
public class TestCallableFuture {

    @SneakyThrows
    public static void main(String[] args) {
        TestCallable testCallable = new TestCallable();
        /** 1、执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。*/
        FutureTask<Integer> taskResult = new FutureTask<>(testCallable);
        System.out.println("=======================主线程start=======================");


        /** 2、新启一个线程，组装FutureTask对象*/
        /*new Thread(taskResult).start();*/
        /** 3、接收线程运算后的结果*/
        /*int intResult = taskResult.get();*/

        /** 另一种方法，使用线程池，返回Future类型对象*/
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Integer> submit = threadPool.submit(testCallable);
        Integer intResult = submit.get();
        System.out.println("结果:" + intResult);
        threadPool.shutdown();


        System.out.println("=======================主线程end=======================");
    }
}