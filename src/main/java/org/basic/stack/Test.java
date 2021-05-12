package org.basic.stack;

/**
 * @Description: 反编译查看JVM执行过程(虚拟机栈)
 * @Author : Lucien
 * @Date Date : 2021-05-08 14:52
 * @Version V1.0
 */
public class Test {

    private static int add(int c) {
        return c + 10;
    }

    public static void main(String[] args) {
        int a, b, c;
        a = 1;
        b = 2;
        c = add(a * b);
        c *= (a + b);
        /*System.out.println(c);*/
    }
}