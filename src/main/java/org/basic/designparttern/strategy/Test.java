package org.basic.designparttern.strategy;

import org.basic.designparttern.strategy.pojo.Cat;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-21 21:59
 * @Version 1.0
 */
public class Test {

    /**
     * 这里面如果我们定义两个以Cat为基础的比较器类（一个是高度一个是重量），就实现了基于"开闭原则"
     * （原来的代码保持不动，重新new一个以其他属性为基础的比较器比较器）为基础的策略模式，这样就可以不断扩展比较策略
     *
     * @param args
     */
    public static void main(String[] args) {
        /*Dog[] a = {new Dog(1), new Dog(5), new Dog(3)};*/
        Cat[] c = {new Cat(15, 20), new Cat(10, 15), new Cat(20, 25)};
        Sorter<Cat> sorter = new Sorter<>();
        /*sorter.sort(c, new CatHeightComparator());*/
        sorter.sort(c, new CatWeightComparator());
        System.out.println(Arrays.toString(c));
    }
}