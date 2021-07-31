package org.basic.designparttern.proxy.cglib;

import lombok.extern.log4j.Log4j2;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-22 22:15
 * @Version 1.0
 */
@Log4j2
public class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        /** 生成的动态代理o对象就是Tank类的子类*/
        log.info(o.getClass().getSuperclass().getName());
        log.info("before...");
        Object o1 = methodProxy.invokeSuper(o, objects);
        log.info("after...");
        return o1;
    }
}