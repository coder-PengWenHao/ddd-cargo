package com.coderpwh.cargo.common.event;

/**
 * @author coderpwh
 * @date 2023/4/28 10:44
 */
public interface DomainEventPublisher {

    void publishEvent(BaseDomainEvent var1);
}
