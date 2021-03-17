package org.basic.thread.callable.constants;

/**
 * @author : Lucien
 * @version V1.0
 * @Description: 线程池构造方法的常量类
 * @date Date : 2021/03/17
 */
public class ThreadConstants {

    /**
     * 核心线程数，当线程池调用 submit 提交一个任务并且当前线程数小于 corePoolSize，就会创建一个新的线程
     * 注意：就算存在空闲线程，也一样会创建新线程
     */
    public static Integer CORE_POOL_SIZE = 5;

    /**
     * 线程池最大允许创建的线程数量，即核心线程数+临时线程总和的最大值
     */
    public static Integer MAXIMUM_POOL_SIZE = 20;

    /**
     * 设置临时线程空闲多长时间才回收
     */
    public static Integer KEEP_ALIVE_TIME = 10;
}
