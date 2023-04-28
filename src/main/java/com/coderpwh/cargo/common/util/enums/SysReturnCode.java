package com.coderpwh.cargo.common.util.enums;

import lombok.Getter;

/**
 * 系统返回状态
 *
 * @since 2021-08-12
 */
@Getter
public enum SysReturnCode {
    //通用代码
    ACCOUNT_OR_PASSWORD_ERROR(10001, "账号或密码错误"),
    ACCOUNT_LOCKOUT(10002, "该账号被禁用"),
    NO_LOGIN_AUTHORITY(10005, "没有登录访问权限"),
    NO_INTERFACE_AUTHORITY(10006, "没有权限对此接口访问"),
    CAPTCHA_EXPIRED(10010, "验证码过期"),
    CAPTCHA_ERROR(10011, "验证码输入错误"),
    OPERATION_UNSUCCESSFUL(10012, "此操作不成功"),
    OPERATION_NOT_ROLE(10013, "用户未绑定角色"),
    OPERATION_NOT_COMPANY(10014, "用户未绑定企业"),
    SENSITIVE_WORDS(10015, "敏感词汇不能使用"),
    INVALID_TOKEN(10016, "无效的token"),
    ACCOUNT_LOGIN_OTHER_TERMINAL(10017, "同一账号在另一客户端登陆"),
    TOKEN_REFRESH_TIMEOUT(10018, "已过刷新日期"),

    //基础服务
    BASE_USR(1001, "用户服务"),
    BASE_SYS(1002, "系统服务"),
    BASE_BUILD(1003, "楼栋服务"),
    BASE_ENTERPRISE(1004, "企业服务"),
    BASE_COMMON(1005, "通用服务"),
    BASE_CUSTOMER(1006, "客户服务"),

    //中台服务
    MIDDLE_USR(1201, "表单服务"),
    MIDDLE_SYS(1202, "流程应用服务"),

    //物业服务
    PEOPERTY_TIK(1301, "工单服务"),
    PEOPERTY_PATROL(1302, "巡更服务"),

    //IOT
    IOT_EQUIPMENT(1401, "设备服务"),
    IOT_ALERT(1402, "告警服务"),
    IOT_STORAGE(1403, "数据储存服务"),
    IOT_STATISTICS(1404, "数据统计服务"),
    IOT_STRATEGY(1405, "策略服务"),
    IOT_MESSAGE(1406, "消息中心"),

    //IOC
    IOC_WEBSOCKET(1501, "websocket服务"),
    IOC_DATAVISUALZATION(1502, "可视化模型服务"),
    IOC_BIGSCREEN(1503, "可视化业务服务"),

    //访客
    PASSING_VISIT(1601, "访客服务"),
    PASSING_PARK(1602, "停车场服务"),

    //Edge
    EDGE_GATEWAY(2001, "硬件网关服务"),
    EDGE_INTEGRATION(2002, "集成服务"),
    EDGE_REGISTRY(2003, "设备注册服务"),
    ASSET_BASE(2004, "资管服务"),


    // CarGo

    CarGo(3001, "CarGo服务"),

    ;

    private final Integer code;

    private final String message;

    SysReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }


}
