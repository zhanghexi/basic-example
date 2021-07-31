package org.basic.designparttern.strategy;

import org.basic.designparttern.strategy.pojo.Cat;

import java.util.Comparator;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-21 22:08
 * @Version 1.0
 */
public class CatWeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getWeight() < o2.getWeight()) return -1;
        else if (o1.getWeight() > o2.getWeight()) return 1;
        else return 0;
    }
}
