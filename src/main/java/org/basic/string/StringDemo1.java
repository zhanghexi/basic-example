package org.basic.string;

/**
 * @Classname StringDemo1
 * @Description
 * @Author Lucien
 * @Date 2021/3/25
 * @Version 1.0
 */
public class StringDemo1 {

    public static void main(String[] args) {
        String a = "something";
        String b = "something";
        /**
         * 不可变性支持字符串常量池
         * 最后别忘了 String 另外一个字符串常量池的属性。像下面这样字符串 a 和 b 都用字面量 "something" 赋值
         * 它们其实都指向同一个内存地址
         * 参考文献：https://blog.csdn.net/u013905744/article/details/52414111
         */
        System.out.println(a.equals(b));

        System.out.println("====================================================================");

        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);

        System.out.println("====================================================================");

        Integer i3 = 1000;
        Integer i4 = 1000;
        System.out.println(i3 == i4);
    }
}
