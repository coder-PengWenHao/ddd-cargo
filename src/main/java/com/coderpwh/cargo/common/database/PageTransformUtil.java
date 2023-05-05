package com.coderpwh.cargo.common.database;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.Page;

import java.util.List;

public class PageTransformUtil {

    public static PageUtils transform(List list) {
        PageUtils returnPage = new PageUtils();
        if (CollectionUtil.isNotEmpty(list) && list instanceof Page) {
            Page page = (Page) list;
            returnPage.setList(page.getResult());
            returnPage.setTotal((int) page.getTotal());
            returnPage.setPageNum(page.getPageNum());
            returnPage.setPageSize(page.getPageSize());
            returnPage.setPages(page.getPages());
        } else {
            returnPage.setList(list);
        }
        return returnPage;
    }

}
