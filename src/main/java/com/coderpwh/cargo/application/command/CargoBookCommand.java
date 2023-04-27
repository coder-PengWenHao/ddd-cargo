package com.coderpwh.cargo.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/4/27 15:51
 */
@Data
public class CargoBookCommand implements Serializable {


    /***
     *  发送者手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String senderPhone;

    /***
     * 描述
     */
    private String description;

    /***
     *编码
     */
    @NotBlank(message = "编码")
    private String originLocationCode;

    /**
     * 编码描述
     */
    private String destinationLocationCode;


}
