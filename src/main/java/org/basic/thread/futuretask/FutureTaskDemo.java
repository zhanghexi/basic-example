package org.basic.thread.futuretask;

import java.util.concurrent.*;

/**
 * @author : Lucien
 * @version V1.0
 * @Description: TODO
 * @date Date : 2021/04/11
 */
public class FutureTaskDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算...");
        TimeUnit.SECONDS.sleep(5);

        int sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += 1;
            System.out.println("当前sum值 = " + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTaskDemo demo = new FutureTaskDemo();

        FutureTask<Integer> futureTask = new FutureTask<>(demo);
        executorService.submit(futureTask);
        System.out.println("主线程在执行任务...");

        try {
            /*主线程会在 futureTask.get()处阻塞，直到 task 任务执行完毕，并且会返回结果*/
            System.out.println("task运行结果 = " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕!");
        executorService.shutdown();
    }
}