package com.coderpwh.cargo.common.util.xss;

import cn.hutool.core.util.StrUtil;
import com.coderpwh.cargo.common.util.exception.BusinessException;

/**
 * @author coderpwh
 * @date 2023/4/28 11:29
 */
public class SQLFilter {

    public SQLFilter() {
    }

    public static String sqlInject(String str) {
        if (StrUtil.isBlank(str)) {
            return null;
        } else {
            str = StrUtil.replace(str, "'", "");
            str = StrUtil.replace(str, "\"", "");
            str = StrUtil.replace(str, ";", "");
            str = StrUtil.replace(str, "\\", "");
            str = str.toLowerCase();
            String[] keywords = new String[]{"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};
            String[] var2 = keywords;
            int var3 = keywords.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                String keyword = var2[var4];
                if (str.indexOf(keyword) != -1) {
                    throw new BusinessException(100, "包含非法字符");
                }
            }

            return str;
        }
    }
}
