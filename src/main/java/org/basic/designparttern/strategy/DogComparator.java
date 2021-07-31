package org.basic.designparttern.strategy;

import org.basic.designparttern.strategy.pojo.Dog;

import java.util.Comparator;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-21 21:57
 * @Version 1.0
 */
public class DogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.getFood() < o2.getFood()) {
            return -1;
        } else if (o1.getFood() > o2.getFood()) {
            return 1;
        }
        return 0;
    }
}