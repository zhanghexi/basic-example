package org.basic.designparttern.decorator;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-07 22:02
 * @Version 1.0
 */
public class SmartPhone implements Phone {

    @Override
    public String desc() {
        return "智能手机";
    }

    @Override
    public int getPrice() {
        return 5000;
    }
}
