package org.basic.designparttern.observer;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-18 16:05
 * @Version 1.0
 */
public interface Observer {

    /**
     * 定义监听器方法
     *
     * @param event
     */
    void actionOnWakeUp(WakeUpEvent event);
}
