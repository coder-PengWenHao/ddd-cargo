package com.coderpwh.cargo.common.util.log;

import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import com.alibaba.fastjson.JSONObject;

/**
 * @author coderpwh
 * @date 2023/4/28 11:04
 */
public class StackTraceConverter extends ThrowableProxyConverter {

    public StackTraceConverter() {
    }

    @Override
    public String convert(ILoggingEvent event) {
        IThrowableProxy throwableProxy = event.getThrowableProxy();
        if (throwableProxy == null) {
            return JSONObject.toJSONString("");
        } else {
            String ex = super.convert(event);
            return JSONObject.toJSONString(ex);
        }
    }
}
