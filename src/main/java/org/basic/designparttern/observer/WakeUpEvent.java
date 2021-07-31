package org.basic.designparttern.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description TODO
 * @Author Lucien
 * @Date 2021-07-18 16:32
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class WakeUpEvent {

    private long timestamp;
    private String loc;
    private Child source;

    /*public WakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }*/
}