package org.basic.thread.callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

/**
 * @Classname ComputeTask
 * @Description 实现Callable接口将线程执行后的结果返回
 * @Author Lucien
 * @Date 2021/3/12
 * @Version 1.0
 */
public class ComputeTask implements Callable<Integer> {

    private static Logger logger = LogManager.getLogger(ComputeTask.class);
    private Integer result = 0;
    private String taskName = "";

    public ComputeTask(Integer result, String taskName) {
        this.result = result;
        this.taskName = taskName;
    }

    public Integer call() throws Exception {
        return toDoWork();
    }

    private Integer toDoWork() {
        logger.info("子线程计算任务:{}开始执行！", taskName);
        for (int i = 0; i < 100; i++) {
            result = i + result;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("线程被中断！", e.getMessage());
        }
        logger.info("子线程计算任务:{}执行完成！结果:{}", taskName, result);
        return result;
    }

    public String getTaskName() {
        return this.taskName;
    }
}
