package com.coderpwh.cargo.common.event;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author coderpwh
 * @date 2023/4/28 10:44
 */
public abstract class BaseDomainEvent<T> implements Serializable {

    private static final long serialVersionUID = 1465328245048581896L;
    private LocalDateTime occurredOn;
    private T data;

    public BaseDomainEvent(T data) {
        this.data = data;
        this.occurredOn = LocalDateTime.now();
    }

    public LocalDateTime getOccurredOn() {
        return this.occurredOn;
    }

    public T getData() {
        return this.data;
    }

    public void setOccurredOn(LocalDateTime occurredOn) {
        this.occurredOn = occurredOn;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseDomainEvent() {
    }

}
