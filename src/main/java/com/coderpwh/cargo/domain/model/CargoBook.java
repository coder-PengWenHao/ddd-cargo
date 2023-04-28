package com.coderpwh.cargo.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/4/27 16:05
 */
@Data
public class CargoBook implements Serializable {

    /***
     *  发送者手机号
     */
    private String senderPhone;

    /***
     * 描述
     */
    private String description;

    /***
     *编码
     */

    private String originlocationCode;

    /**
     * 编码描述
     */
    private String destinationlocationCode;


}
