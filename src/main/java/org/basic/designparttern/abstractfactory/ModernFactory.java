package org.basic.designparttern.abstractfactory;

/**
 * @Description 在此定制自己的具体工厂(现代工厂从总的抽象工厂继承 ， 实现具体的方法)
 * 之后会有"古代工厂"，生产古代的产品
 * @Author Lucien
 * @Date 2021-07-01 23:13
 * @Version 1.0
 */
public class ModernFactory extends AbstractFactory {

    @Override
    Food createFood() {
        /**实现面包*/
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        /**实现汽车*/
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        /**实现AK47*/
        return new AK47();
    }
}