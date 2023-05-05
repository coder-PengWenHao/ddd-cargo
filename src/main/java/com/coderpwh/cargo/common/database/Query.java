package com.coderpwh.cargo.common.database;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * Query类
 * </p>
 *
 * @author liutianhua
 * @since 2021-03-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Query<T> extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private static final String PAGE_NUM_KEY = "pageNum";

    private static final String PAGE_SIZE_KEY = "pageSize";

    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页条数
     */
    private int pageSize = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        if (params.get(PAGE_NUM_KEY) != null) {
            pageNum = Integer.parseInt((String) params.get(PAGE_NUM_KEY));
        }
        if (params.get(PAGE_SIZE_KEY) != null) {
            pageSize = Integer.parseInt((String) params.get(PAGE_SIZE_KEY));
        }
        this.page = new Page<>(pageNum, pageSize);

    }

    public Query(Integer pageSize, Integer pageNum) {
        if (null != pageSize && pageSize > 0) {
            this.pageSize = pageSize;
        }
        if (null != pageNum && pageNum > 0) {
            this.pageNum = pageNum;
        }
        this.page = new Page<>(this.pageNum, this.pageSize);
    }
}
