package org.basic.designparttern.decorator;

/**
 * @Description 装饰器模式的接口(基本抽象组件Component，里面包含基本的方法)
 * 可以理解为统一的角色：装饰者和被装饰者具有相同的父类
 * @Author Lucien
 * @Date 2021-07-07 21:57
 * @Version 1.0
 */
public interface Phone {

    /**
     * 手机型号描述
     */
    String desc();

    /**
     * 价格
     */
    int getPrice();
}