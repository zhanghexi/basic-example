package org.basic.designparttern.strategy;

import org.basic.designparttern.strategy.pojo.Cat;

import java.util.Comparator;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-21 22:09
 * @Version 1.0
 */
public class CatHeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getHeight() < o2.getHeight()) return 1;
        else if (o1.getHeight() > o2.getHeight()) return -1;
        else return 0;
    }
}
