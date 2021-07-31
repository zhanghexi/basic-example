package org.basic.designparttern.proxy.dynamic;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 打印 Tank 日志
 * @Author Lucien
 * @Date 2021-07-20 16:24
 * @Version 1.0
 */
@AllArgsConstructor
public class TankInvocationHandler implements InvocationHandler {

    private Tank tank;

    /**
     * @param proxy  生成的代理对象(move)
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /** 在此实现作为代理来说，自己的逻辑*/
        System.out.println("method " + method.getName() + " start...");
        Object o = method.invoke(tank, args);
        System.out.println("method " + method.getName() + " end...");
        return o;
    }
}