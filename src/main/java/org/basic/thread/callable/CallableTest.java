package org.basic.thread.callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Classname CallableTest
 * @Description 测试线程执行的返回值
 * @Author Lucien
 * @Date 2021/3/12
 * @Version 1.0
 */
public class CallableTest {

    private static Logger logger = LogManager.getLogger(ComputeTask.class);

    public static void main(String[] args) {
        //1、创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //2、create a list of Callable
        List<Future<Integer>> returnFutureList = new ArrayList<Future<Integer>>(16);

        for (int i = 0; i < 20; i++) {
            ComputeTask computeTask = new ComputeTask(30 + i, "work_" + i);
            Future<Integer> future = executorService.submit(computeTask);
            returnFutureList.add(future);
        }
        logger.info("提交完了任务，可以把其他事情做完了，再来轮询获取线程返回的结果的信息");
        for (int i = 0; i < returnFutureList.size(); i++) {
            Future<Integer> future = null;
            Integer taskReturnTable = null;
            try {
                future = returnFutureList.get(i);
                // 依次阻塞一直等待获取到结果的信息
                taskReturnTable = future.get();
            } catch (InterruptedException e) {
                logger.error("当前线程中断:{}", e.getMessage());
                Thread.currentThread().interrupt();//重新声明线程中断了
                if (future != null) {
                    future.cancel(true);
                }
            } catch (ExecutionException e) {
                logger.error("执行线程异常:{}", e.getMessage());
                if (future != null) {
                    future.cancel(true);
                }
            } finally {
                logger.info("返回的Result:{}", taskReturnTable);
            }
        }
    }
}