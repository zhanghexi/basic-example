package org.basic.designparttern.factorymethod;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-22 21:32
 * @Version 1.0
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SimpleVehicleFactory factory = new SimpleVehicleFactory();
        Car car = factory.createCar();
        car.go();

        Plane plane = factory.createPlane();
        plane.go();


        /** 任意定制交通工具(实现moveable接口)*/
        /*Moveable moveable = new CarFactory().create();*/
        /**任意定制生产过程(用不同的factory，再create(在此先生产出来car，然后car再go...)*/
        /*moveable.go();*/
    }
}