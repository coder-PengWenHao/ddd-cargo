package com.coderpwh.cargo.common.util.log;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.alibaba.fastjson.JSONObject;

/**
 * @author coderpwh
 * @date 2023/4/28 11:03
 */
public class MsgConverter extends ClassicConverter {

    public MsgConverter() {
    }

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return JSONObject.toJSONString(iLoggingEvent.getFormattedMessage());
    }
}
