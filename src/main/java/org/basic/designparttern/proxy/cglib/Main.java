package org.basic.designparttern.proxy.cglib;

import lombok.extern.log4j.Log4j2;
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

@Log4j2
class Tank {

    public void move() {
        log.info("Tank moving...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}