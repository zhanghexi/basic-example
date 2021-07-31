package org.basic.designparttern.decorator;

/**
 * @Description 具体装饰物：负责给基础组件添加新的功能（例如下面的视频通话功能）
 * 添加视频通话的装饰器类
 * @Author Lucien
 * @Date 2021-07-07 22:10
 * @Version 1.0
 */
public class VideoDecorator extends PhoneDecorator {

    private String desc = "增加一个视频通话功能";

    private int videoPrice = 500;

    private Phone phone;

    public VideoDecorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String desc() {
        return phone.desc() + " , " + desc;
    }

    @Override
    public int getPrice() {
        return phone.getPrice() + videoPrice;
    }
}
