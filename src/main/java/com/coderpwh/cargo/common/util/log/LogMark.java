package com.coderpwh.cargo.common.util.log;

import com.alibaba.fastjson.JSONObject;

/**
 * @author coderpwh
 * @date 2023/4/28 11:02
 */
public class LogMark {

    public LogMark() {
    }

    public static String format(String mark, String content) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mark", mark);
        jsonObject.put("content", content);
        return jsonObject.toJSONString();
    }

    public static String format(String mark) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mark", mark);
        return jsonObject.toJSONString();
    }
}
