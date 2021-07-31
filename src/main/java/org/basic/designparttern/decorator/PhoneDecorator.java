package org.basic.designparttern.decorator;

/**
 * @Description 定义统一的手机装饰器(装饰者组件Component)，也就是具体扩展功能的统一封装
 * 并持有组件(Component)对象实例的引用：VideoDecorator 和 WifiChargeDecorator
 * 相当于中间层作用，方便后面的扩展，具体的装饰实现延迟到子类中
 * @Author Lucien
 * @Date 2021-07-07 22:08
 * @Version 1.0
 */
public class PhoneDecorator implements Phone {

    @Override
    public String desc() {
        return "this is decorator";
    }

    @Override
    public int getPrice() {
        return 0;
    }
}