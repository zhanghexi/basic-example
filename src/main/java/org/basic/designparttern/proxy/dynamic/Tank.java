package org.basic.designparttern.proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-20 16:13
 * @Version 1.0
 */
public class Tank implements Moveable {
    /**
     * 模拟坦克移动一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /** 通过设置参数，将生成的代理类的.class文件保存在本地*/
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Tank tank = new Tank();
        /** 通过调用Proxy.newProxyInstance生成代理对象*/
        Moveable move = (Moveable) Proxy.newProxyInstance(
                /**1、classLoader*/
                Tank.class.getClassLoader(),
                /** 2、要代理的接口*/
                new Class[]{Moveable.class},
                /** 3、代理对象的InvocationHandler实现类，指定被代理的方法在被调用的时候该怎么处理*/
                new TankInvocationHandler(tank));
        /** 这里调用代理对象的move方法，实际调用invoke方法*/
        move.move();
    }
}

interface Moveable {

    void move();
}