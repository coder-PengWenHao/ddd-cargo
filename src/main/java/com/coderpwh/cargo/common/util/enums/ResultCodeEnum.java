package com.coderpwh.cargo.common.util.enums;

import lombok.Getter;

/**
 * ResultCodeEnum类
 * @author coderpwh
 */
@Getter
public enum ResultCodeEnum {

    /**
     * 服务器成功返回，操作成功统一返回200。
     */
    SUCCESS(200, 200, "SUCCESS"),

    CREATED(201, 201, "SUCCESS"),

    NO_CONTENT(204, 204, "SUCCESS"),

    /**
     * 用户发出的请求有错误或格式有误，服务器无法理解此请求。
     */
    BAD_REQUEST(400, 400, "BAD_REQUEST"),

    /**
     * 表示用户没有权限（令牌错误或过期）。
     */
    UNAUTHORIZED(401, 401, "UNAUTHORIZED"),

    /**
     * 表示用户没有获得授权
     */
    FORBIDDEN(403, 403, "FORBIDDEN"),

    /**
     * 用户发出的请求不存在，服务器找不到地址。
     */
    NOFOUND(404, 404, "NOT_FOUND"),

    CONFLICT(409, 409, "CONFLICT"),

    /**
     * 服务器发生错误
     */
    INTERNAL_SERVER_ERROR(500, 500, "INTERNAL_SERVER_ERROR");

    /**
     * 系统错误码
     */
    public int code;

    /**
     * http状态码
     */
    public int httpStatus;

    public String errorMsg;

    ResultCodeEnum(int code, int httpStatus, String errorMsg) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.errorMsg = errorMsg;
    }

}
