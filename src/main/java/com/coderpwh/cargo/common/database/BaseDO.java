package com.coderpwh.cargo.common.database;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础PO
 *
 * @author Weiping.wang
 * @date 2021-05-31
 **/
@Data
public class BaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 删除标识
     */
    private Integer isDeleted;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新人
     */
    private Integer updatedBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

}

