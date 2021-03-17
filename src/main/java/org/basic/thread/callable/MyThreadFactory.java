package org.basic.thread.callable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * @author : Lucien
 * @version V1.0
 * @Description: 自定义线程工厂
 * @date Date : 2021/03/17
 */
public class MyThreadFactory implements ThreadFactory {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("this is a test thread - " + format.format(new Date()));
        return newThread;
    }
}