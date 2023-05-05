package com.coderpwh.cargo.common.database;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 描述:Bean基类
 *
 * @author LLT
 * @create 2019-12-18 10:45
 */
//@Getter
//@Setter
public class BasePage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4469902871210372742L;

    private static final int MAX_PAGE_SIZE = 1000;

    /**
     * 分页数
     */
    //@Positive(message = "pageSize 必须是正数", groups = {QueryGroup.class})
    //@NotNull(message = "pageSize 不能为空", groups = {QueryGroup.class})
    private int pageSize = MAX_PAGE_SIZE;

    /**
     * 当前页
     */
    //@Positive(message = "pageNum 必须是正数", groups = {QueryGroup.class})
    //@NotNull(message = "pageNum 不能为空", groups = {QueryGroup.class})
    private int pageNum = 1;

    /**
     * 是否需要分页
     */
    @Getter
    @Setter
    private boolean isNeedPage = true;

    public int getPageSize() {
        if (pageSize < 1) {
            return MAX_PAGE_SIZE;
        }
        if (pageSize > MAX_PAGE_SIZE) {
            return MAX_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        if (pageNum < 1) {
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
