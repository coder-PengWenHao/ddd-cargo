package com.coderpwh.cargo.common.util.enums;

/**
 * @author coderpwh
 * @date 2023/4/28 11:08
 */
public enum DddEnum {

    WEB(1),
    APPLICATIN(2),
    DOMAIN(3),
    INFRASTRUCTURE(4);

    private Integer level;

    private DddEnum(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return this.level;
    }
}
