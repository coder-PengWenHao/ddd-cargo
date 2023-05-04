package com.coderpwh.cargo.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/4 14:01
 */
@Data
public class CargoBookDTO implements Serializable {


    private String id;

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
