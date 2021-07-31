package org.basic.designparttern.decorator;

/**
 * @Description 具体装饰物：负责给基础组件添加新的功能（例如下面的wifi充电功能）
 * 增加wifi充电功能的装饰器类
 * @Author Lucien
 * @Date 2021-07-07 22:11
 * @Version 1.0
 */
public class WifiChargeDecorator extends PhoneDecorator {

    private String desc = "增加一个wifi充电功能";

    private int wifiAddPrice = 800;

    private Phone phone;

    public WifiChargeDecorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String desc() {
        return phone.desc() + " , " + desc;
    }

    @Override
    public int getPrice() {
        return phone.getPrice() + wifiAddPrice;
    }
}
