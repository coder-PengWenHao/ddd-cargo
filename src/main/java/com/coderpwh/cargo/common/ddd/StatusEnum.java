package com.coderpwh.cargo.common.ddd;

import cn.hutool.core.util.StrUtil;

/**
 * @author coderpwh
 * @date 2023/4/28 10:37
 */
public enum StatusEnum implements ValueObject<StatusEnum> {
    ENABLE("0", "有效"),
    DISABLE("1", "禁用");

    private String value;
    private String label;

    private StatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public static String getLabelByValue(String value) {
        if (StrUtil.isBlank(value)) {
            return "";
        } else {
            StatusEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                StatusEnum s = var1[var3];
                if (value.equals(s.getValue())) {
                    return s.getLabel();
                }
            }

            return "";
        }
    }

    public static StatusEnum getStatusEnum(String value) {
        if (StrUtil.isBlank(value)) {
            return null;
        } else {
            StatusEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                StatusEnum s = var1[var3];
                if (value.equals(s.getValue())) {
                    return s;
                }
            }

            return null;
        }
    }

    @Override
    public boolean sameValueAs(StatusEnum other) {
        return this.equals(other);
    }
}
