package org.basic.designparttern.decorator;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-07 22:18
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        /**
         * 基础测试
         */
        Phone phone = new SmartPhone();
        System.out.println(phone.desc() + " --- " + phone.getPrice());
        System.out.println();

        /**
         * 增加视频通话功能
         */
        phone = new VideoDecorator(phone);
        System.out.println(phone.desc() + " --- " + phone.getPrice());
        System.out.println();

        /**
         * 增加wifi功能
         */
        phone = new WifiChargeDecorator(phone);
        System.out.println(phone.desc() + " --- " + phone.getPrice());
    }
}
