package org.basic.thread.callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.basic.thread.callable.constants.ThreadConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Classname CallableTest
 * @Description 测试线程执行的返回值
 * 参考文献：https://blog.csdn.net/qq_28834355/article/details/109513766
 * @Author Lucien
 * @Date 2021/3/12
 * @Version 1.0
 */
public class CallableTest {

    private static Logger logger = LogManager.getLogger(ComputeTask.class);

    public static void main(String[] args) {
        //1、创建线程池
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                ThreadConstants.CORE_POOL_SIZE,
                ThreadConstants.MAXIMUM_POOL_SIZE,
                ThreadConstants.KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                /*设置阻塞队列的队列类型，以及队列的容量大小*/
                new LinkedBlockingQueue<Runnable>(50),
                /*设置创建线程的线程工厂类*/
                new MyThreadFactory(),
                /*当工作线程数达到maximumPoolSize并且当下没有空闲线程，假如有新的任务继续提交进来，将采取指定的策略进行拒绝处理*/
                new MyRejectedExecutionHandler());

        //2、create a list of Callable(创建任务列表)
        List<Future<Integer>> returnFutureList = new ArrayList<Future<Integer>>(16);

        for (int i = 0; i < 20; i++) {
            ComputeTask computeTask = new ComputeTask((i + 1), "任务" + (i + 1));
            Future<Integer> future = executorService.submit(computeTask);
            returnFutureList.add(future);
        }
        logger.info("全部任务已提交，可以把其他事情做完了，再来轮询获取线程返回的结果......");
        /*3、获取线程执行返回的结果*/
        for (int i = 0; i < returnFutureList.size(); i++) {
            Future<Integer> future = null;
            Integer taskReturnTable = null;
            try {
                /*获取future对象*/
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