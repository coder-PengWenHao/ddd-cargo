package com.coderpwh.cargo.common.util.validator;

import cn.hutool.core.util.StrUtil;
import com.coderpwh.cargo.common.util.exception.BusinessException;

/**
 * @author coderpwh
 * @date 2023/4/28 10:56
 */
public abstract class Assert {

    public Assert() {
    }

    public static void isBlank(String str, String message) {
        if (StrUtil.isBlank(str)) {
            throw new BusinessException(100, message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new BusinessException(100, message);
        }
    }

}
