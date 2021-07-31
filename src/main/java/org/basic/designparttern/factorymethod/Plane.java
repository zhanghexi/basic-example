package org.basic.designparttern.factorymethod;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-22 21:33
 * @Version 1.0
 */
public class Plane implements Moveable {

    @Override
    public void go() {
        System.out.println("plane fly...");
    }
}