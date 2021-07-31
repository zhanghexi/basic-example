//package org.basic.designparttern.factorymethod;
//
///**
// * @Description 当添加一个新交通工具的时候，先要把它的factory工厂创建出来
// * @Author Lucien
// * @Date 2021-06-30 22:41
// * @Version 1.0
// */
//public class CarFactory {
//
//    /**
//     * 这里更严格的写法是每种工厂生产出的返回值都应是Movable接口，更完美
//     */
//    public Moveable create() {
//        /** 可以加权限处理和各种其他处理*/
//        System.out.println("a car created!");
//        return new Car();
//    }
//}
