package com.coderpwh.cargo.common.util.enums;

/**
 * @author coderpwh
 * @date 2023/4/28 11:09
 */
public enum DeletedFlagEnum {
    DELETED_1(1, "是否删除标记:已删除"),
    UNDELETE_0(0, "是否删除标记:未删除");

    private int isDeleted;
    private String desc;

    private DeletedFlagEnum(int isDeleted, String desc) {
        this.isDeleted = isDeleted;
        this.desc = desc;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public String getDesc() {
        return this.desc;
    }
}
