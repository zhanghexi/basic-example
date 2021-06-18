package org.basic.thread.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-03 16:13
 * @Version 1.0
 */
public class AtomicVolatileTest {

    AtomicInteger count = new AtomicInteger(0);

    public void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();    //count++
        }
    }

    public static void main(String[] args) {
        AtomicVolatileTest test = new AtomicVolatileTest();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(test::m, "thread - " + i));
        }
        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(test.count);
        /*String fileName = "/data/asap/ssa/app/unicom/file/2021年06月02日日报 (3)_1622712915928_46440.xlsx";
        String[] split = fileName.split("/");
        System.out.println(split[split.length - 1]);*/
    }
}