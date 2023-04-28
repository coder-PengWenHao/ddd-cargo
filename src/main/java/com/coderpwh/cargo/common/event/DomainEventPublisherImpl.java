package com.coderpwh.cargo.common.event;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author coderpwh
 * @date 2023/4/28 10:45
 */
@Component
public class DomainEventPublisherImpl implements DomainEventPublisher {
    private static final Logger log = LoggerFactory.getLogger(DomainEventPublisherImpl.class);
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public DomainEventPublisherImpl() {
    }

    @Override
    public void publishEvent(BaseDomainEvent event) {
        log.debug("发布事件,event:{}", JSONUtil.toJsonStr(event));
        this.applicationEventPublisher.publishEvent(event);
    }
}
