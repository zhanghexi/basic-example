package org.basic.designparttern.abstractfactory;

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
        /**基于现代工厂实现*/
        AbstractFactory factory = new ModernFactory();

        Food food = factory.createFood();
        food.printName();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();
    }
}