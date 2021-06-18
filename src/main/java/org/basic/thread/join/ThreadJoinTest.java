package org.basic.thread.join;

/**
 * @Description: TODO
 * @Author : Lucien
 * @Date Date : 2021-06-02 16:04
 * @Version V1.0
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1线程执行...");
        });

        Thread t2 = new Thread(() -> {
            /*System.out.println("t1线程执行...");*/
            try {
                t1.join();//这里等待t1执行完毕后再往下执行
                System.out.println("t2线程执行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();//这里等待t2执行完毕后再往下执行
                System.out.println("t3线程执行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("开始执行三个线程...");
        t3.start();
        t2.start();
        t1.start();
    }
}