package org.basic.designparttern.strategy;

import java.util.Comparator;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-06-21 21:52
 * @Version 1.0
 */
public class Sorter<T> {

    /**
     * 具体的比较算法，传入要比较的对象和实现了Comparator接口的比较器
     *
     * @param arr
     * @param comparator
     */
    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
