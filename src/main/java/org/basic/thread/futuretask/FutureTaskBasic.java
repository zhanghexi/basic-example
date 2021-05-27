package org.basic.thread.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: TODO
 * @Author : Lucien
 * @Date Date : 2021-05-25 16:27
 * @Version V1.0
 */
public class FutureTaskBasic implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 100;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start......");

        FutureTaskBasic futureTaskBasic = new FutureTaskBasic();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(futureTaskBasic);

        new Thread(integerFutureTask, "有返回值的线程").start();
        Integer integer = integerFutureTask.get();

        System.out.println("返回值:" + integer);

        System.out.println("end......");
    }
}