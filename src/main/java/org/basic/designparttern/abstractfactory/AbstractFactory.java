package org.basic.designparttern.abstractfactory;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-01 22:55
 * @Version 1.0
 */
public abstract class AbstractFactory {

    /**
     * 抽象工厂会产生3个抽象产品(分别代表三大不同的产品抽象，食品、汽车和武器)，然后在继承类里面生产具体的产品
     */
    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();
}