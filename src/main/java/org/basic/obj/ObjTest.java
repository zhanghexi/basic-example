package org.basic.obj;

/**
 * @Description: TODO
 * @Author : Lucien
 * @Date Date : 2021-05-25 14:54
 * @Version V1.0
 */
public class ObjTest {

    public static void main(String[] args) {
        /**
         * 具体的执行过程(汇编指令)
         * 0 new #2 <java/lang/Object>  :在内存开辟一块空间，成员变量赋默认值，为半初始化状态
         * 3 dup
         * 4 invokespecial #1 <java/lang/Object.<init>>     :；调用构造方法，成员变量赋初始的值
         * 7 astore_1   建立关联(和局部变量的引用建立关联，new出来的Object()指向o)
         * 8 return
         */
        Object o = new Object();
    }
}
