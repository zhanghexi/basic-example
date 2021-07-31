package org.basic.designparttern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

import java.util.concurrent.TimeUnit;

/**
 * @Description CGlib实现动态代理不需要接口（其底层用的也是asm）
 * @Author Lucien
 * @Date 2021-07-22 22:14
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}


class Tank {

    public void move() {
        System.out.println("Tank moving...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}