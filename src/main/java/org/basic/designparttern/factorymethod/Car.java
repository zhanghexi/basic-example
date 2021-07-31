package org.basic.designparttern.factorymethod;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-22 21:32
 * @Version 1.0
 */
public class Car implements Moveable {

    @Override
    public void go() {
        System.out.println("car go...");
    }
}