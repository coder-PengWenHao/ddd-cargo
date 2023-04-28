package com.coderpwh.cargo.common.util.exception;

import cn.hutool.core.util.ObjectUtil;
import com.coderpwh.cargo.common.util.enums.DddEnum;
import com.coderpwh.cargo.common.util.enums.SysReturnCode;

/**
 * @author coderpwh
 * @date 2023/4/28 11:06
 */
public class BusinessException extends RuntimeException  {

    private Integer code;
    private String message;
    private Integer actionType;

    public BusinessException(SysReturnCode returnCode, DddEnum dddEnum, String message) {
        String code = returnCode.code() + "" + dddEnum.getLevel();
        this.code = Integer.valueOf(code);
        this.message = ObjectUtil.isNotNull(message) ? message : returnCode.message();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public BusinessException(Integer code, String message, Integer actionType) {
        super(message);
        this.message = message;
        this.code = code;
        this.actionType = actionType;
    }

    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public Integer getActionType() {
        return this.actionType;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "BusinessException(code=" + this.getCode() + ", message=" + this.getMessage() + ", actionType=" + this.getActionType() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BusinessException)) {
            return false;
        } else {
            BusinessException other = (BusinessException) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$actionType = this.getActionType();
                Object other$actionType = other.getActionType();
                if (this$actionType == null) {
                    if (other$actionType != null) {
                        return false;
                    }
                } else if (!this$actionType.equals(other$actionType)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BusinessException;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $actionType = this.getActionType();
        result = result * 59 + ($actionType == null ? 43 : $actionType.hashCode());
        return result;
    }
}
