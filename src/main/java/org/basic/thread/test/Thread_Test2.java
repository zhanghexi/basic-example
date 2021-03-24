package org.basic.thread.test;

import lombok.SneakyThrows;

/**
 * @Classname Thread_Test2
 * @Description
 * @Author Lucien
 * @Date 2021/3/23
 * @Version 1.0
 */
public class Thread_Test2 {

    public static void main(String[] args) {
        Add add = new Add();
        /*Add add1 = new Add();*/
        /*两个线程获取的是同一个对象锁，可以确保按顺序执行*/
        ThreadA threadAA = new ThreadA(add);
        threadAA.start();
        ThreadB threadBB = new ThreadB(add);
        threadBB.start();
    }
}

class ThreadA extends Thread {
    private Add a;

    public ThreadA(Add add) {
        this.a = add;
    }

    @Override
    public void run() {
        a.add("a");
    }
}

class ThreadB extends Thread {
    private Add b;

    public ThreadB(Add add) {
        this.b = add;
    }

    @Override
    public void run() {
        b.add("b");
    }
}


class Add {
    private int num = 0;

    /**
     * 同步方法
     *
     * @param username
     */
    @SneakyThrows
    public void add(String username) {
        synchronized (this) {
            if (username.equals("a")) {
                num = 100;
                System.out.println("add a end");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("add b end");
                Thread.sleep(1000);
            }
            System.out.println(username + " name " + num);
        }
    }
}