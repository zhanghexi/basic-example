package org.basic.thread.futuretask;

import java.util.concurrent.Callable;

/**
 * @Description: TODO
 * @Author : Lucien
 * @Date Date : 2021-05-27 16:06
 * @Version V1.0
 */
public class TestCallable implements Callable<Integer> {

    private static final int repeatCount = 1000;

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < repeatCount; i++) {
            result += (i + 1);
        }
        return result;
    }
}