package org.basic.thread.dcl;

import java.util.concurrent.TimeUnit;

/**
 * @Description: DCL双重检查机制
 * @Author : Lucien
 * @Date Date : 2021-06-03 11:49
 * @Version V1.0
 */
public class DCLTest {

    private static volatile DCLTest instance;

    private DCLTest() {
    }

    public static DCLTest getInstance() {
        if (instance == null) {
            synchronized (DCLTest.class) {
                if (instance == null) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new DCLTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                System.out.println(DCLTest.getInstance().hashCode());
            }).start();
        }
    }
}