package org.basic.thread.callable;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : Lucien
 * @version V1.0
 * @Description: 自定义线程池拒绝策略（默认的拒绝策略是AbortPolicy，直接抛出异常，提示没有提交成功）
 * @date Date : 2021/03/17
 */
public class MyRejectedExecutionHandler extends ThreadPoolExecutor.AbortPolicy {

    public MyRejectedExecutionHandler() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        throw new RejectedExecutionException("任务 " + r.toString() + " 被线程池拒绝，from " + executor.toString());
    }
}