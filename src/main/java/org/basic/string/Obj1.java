package org.basic.string;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.FieldLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Lucien
 * @version V1.0
 * @Description: TODO
 * @date Date : 2021/03/26
 */
public class Obj1 {

    public static Object generate() {
        ConcurrentHashMap<String, Object> cMap = new ConcurrentHashMap<>(16);
        cMap.putIfAbsent("a", new Integer(1));
        cMap.putIfAbsent("b", "b");
        cMap.putIfAbsent("c", new Date());

        for (int i = 0; i < 10; i++) {
            cMap.put(String.valueOf(i), String.valueOf(i));
        }
        return cMap;
    }

    public static void printInfo(String msg) {
        System.out.println(msg);
        System.out.println("=============================================================");
    }

    public static void main(String[] args) {
        Object obj = generate();
        /*查看对象内部信息*/
        printInfo(ClassLayout.parseInstance(obj).toPrintable());
        /*查看对象外部信息*/
        printInfo(GraphLayout.parseInstance(obj).toPrintable());
        /*获取对象总大小*/
        printInfo("size = " + GraphLayout.parseInstance(obj).totalSize());

        /*Object obj = new Object();
         *//*查看对象内部信息*//*
        System.out.println("对象内部信息:\n" + ClassLayout.parseInstance(obj).toPrintable());
        *//*查看对象外部信息，包括引用的对象*//*
        System.out.println("对象外部信息:\n" + GraphLayout.parseInstance(obj).toPrintable());

        System.out.println("=============================================================");*/
    }
}