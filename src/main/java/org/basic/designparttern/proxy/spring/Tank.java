package org.basic.designparttern.proxy.spring;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-22 23:19
 * @Version 1.0
 */
@Log4j2
public class Tank {

    /**
     * 模拟坦克移动一段时间
     */
    public void move() {
        log.info("Tank moving...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
