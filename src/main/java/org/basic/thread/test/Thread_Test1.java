package org.basic.thread.test;

/**
 * @Classname Thread_Test1
 * @Description
 * @Author Lucien
 * @Date 2021/3/23
 * @Version 1.0
 */
public class Thread_Test1 {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        System.out.println("--------------------");

        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Hello Lambda!");
        }).start();
    }
}
