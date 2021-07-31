package org.basic.designparttern.proxy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-22 23:25
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("aop.xml");
        Tank t = (Tank) act.getBean("tank");
        t.move();
    }
}
