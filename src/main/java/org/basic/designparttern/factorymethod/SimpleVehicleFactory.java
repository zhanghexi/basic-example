package org.basic.designparttern.factorymethod;

/**
 * @Description 将new Plane();、new Car()交给该工厂去处理(简单工厂)
 * 但他的可扩展性不好，如果再要新添一个创建某样东西的方法还要改代码，违反开闭原则
 * 详见CarFactory
 * @Author Lucien
 * @Date 2021-06-30 22:37
 * @Version 1.0
 */
public class SimpleVehicleFactory {

    public Car createCar() {
        /** 在此可以加权限、日志处理等前置操作*/
        return new Car();
    }

    public Plane createPlane() {
        return new Plane();
    }
}