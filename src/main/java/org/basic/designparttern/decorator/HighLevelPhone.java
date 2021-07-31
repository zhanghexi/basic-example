package org.basic.designparttern.decorator;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-07 22:03
 * @Version 1.0
 */
public class HighLevelPhone implements Phone {

    @Override
    public String desc() {
        return "尊贵版手机";
    }

    @Override
    public int getPrice() {
        return 12000;
    }
}
