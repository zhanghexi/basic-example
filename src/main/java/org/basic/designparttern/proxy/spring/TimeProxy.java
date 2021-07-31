package org.basic.designparttern.proxy.spring;

import lombok.extern.log4j.Log4j2;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-22 23:17
 * @Version 1.0
 */
@Log4j2
public class TimeProxy {

    public void before() {
        log.info("tank before..." + System.currentTimeMillis());
    }

    public void after() {
        log.info("tank after..." + System.currentTimeMillis());
    }
}
