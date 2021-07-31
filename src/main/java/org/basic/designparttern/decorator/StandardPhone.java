package org.basic.designparttern.decorator;

/**
 * @Description 具体的被装饰者的实现，以手机为例
 * @Author Lucien
 * @Date 2021-07-07 22:01
 * @Version 1.0
 */
public class StandardPhone implements Phone {

    @Override
    public String desc() {
        return "标准版手机";
    }

    @Override
    public int getPrice() {
        return 1200;
    }
}