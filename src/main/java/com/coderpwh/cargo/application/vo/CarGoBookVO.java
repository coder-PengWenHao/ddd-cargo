package com.coderpwh.cargo.application.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coderpwh
 * @date 2023/5/4 10:36
 */
@Data
public class CarGoBookVO implements Serializable {


    private String id;

    private String senderPhone;

    private String description;

    private String originlocationCode;

    private String destinationlocationCode;

    private Date createdAt;

    private Date updatedAt;

}
