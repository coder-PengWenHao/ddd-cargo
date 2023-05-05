package com.coderpwh.cargo.common.database;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具
 *
 * @param <T>
 * @author liutianhua
 * @since 2020/03/12
 */
@Getter
@Setter
public class PageUtils<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private int pageNum = 1;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private int total;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 数据列表
     */
    private List<T> list;

    public PageUtils() {

    }

    public PageUtils(IPage<T> page) {
        if (page != null) {
            pageNum = new Long(page.getCurrent()).intValue();
            pageSize = new Long(page.getSize()).intValue();
            total = new Long(page.getTotal()).intValue();
            pages = new Long(page.getPages()).intValue();
            list = page.getRecords();
        }
    }
}
