package com.coderpwh.cargo.common.util.exception;

import cn.hutool.core.util.ObjectUtil;
import com.coderpwh.cargo.common.util.log.LogMark;
import com.coderpwh.cargo.common.util.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/**
 * @author coderpwh
 * @date 2023/4/28 10:58
 */
@RestControllerAdvice
public class RestExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionAdvice.class);
    @Value("${spring.profiles.active:}")
    private String active;
    public static final String REST_EXCEPTION = "rest_exception";

    public RestExceptionAdvice() {
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result httpRequestMethodNotSuppertedException(HttpRequestMethodNotSupportedException ex, HttpServletResponse response, HttpServletRequest request) {
        if (this.active.equals("prd")) {
            log.error(LogMark.format("rest_exception", "httpRequestMethodNotSuppertedException"), ex);
        } else {
            log.error(ex.getMessage(), ex);
        }

        response.setStatus(HttpStatus.NOT_FOUND.value());
        return Result.error(HttpStatus.NOT_FOUND.value(), "请求路径错误或者请求方式错误(method)");
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public Result noHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equalsIgnoreCase(RequestMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return Result.ok();
        } else {
            if (this.active.equals("prd")) {
                log.error(LogMark.format("rest_exception", "NoHandlerFoundException request url：{}，request method：{}"), new Object[]{request.getRequestURI(), request.getMethod(), ex});
            } else {
                log.error(ex.getMessage(), ex);
            }

            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Result.error(HttpStatus.NOT_FOUND.value(), "找不到请求路径");
        }
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletResponse response, HttpServletRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sbf = new StringBuilder();
        List<ObjectError> errors = bindingResult.getAllErrors();
        Iterator var7 = errors.iterator();

        while(var7.hasNext()) {
            ObjectError error = (ObjectError)var7.next();

            try {
                Field field = error.getClass().getDeclaredField("field");
                field.setAccessible(true);
                sbf.append(field.get(error)).append(" ").append(error.getDefaultMessage()).append(";");
            } catch (Exception var10) {
                var10.printStackTrace();
            }
        }

        if (this.active.equals("prd")) {
            log.error(LogMark.format("rest_exception", "MethodArgumentNotValidException request url：{}，request method：{}"), new Object[]{request.getRequestURI(), request.getMethod(), ex});
        } else {
            log.error(ex.getMessage(), ex);
        }

        response.setStatus(HttpStatus.OK.value());
        return Result.error(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler({NullPointerException.class})
    public Result nullPointerException(Exception ex, HttpServletResponse response, HttpServletRequest request) {
        if (this.active.equals("prd")) {
            log.error(LogMark.format("rest_exception", "NullPointerException request url：{}，request method：{}"), new Object[]{request.getRequestURI(), request.getMethod(), ex});
        } else {
            log.error(ex.getMessage(), ex);
        }

        response.setStatus(HttpStatus.OK.value());
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "歇一歇，再试试");
    }

    @ExceptionHandler({BusinessException.class})
    public Result msgException(BusinessException ex, HttpServletResponse response, HttpServletRequest request) {
        if (this.active.equals("prd")) {
            log.error(LogMark.format("rest_exception", "BusinessException request url：{}，request method：{}"), new Object[]{request.getRequestURI(), request.getMethod(), ex});
        } else {
            log.error(ex.getMessage(), ex);
        }

        response.setStatus(HttpStatus.OK.value());
        return ex.getActionType() != null ? Result.error(ex.getCode() == null ? HttpStatus.INTERNAL_SERVER_ERROR.value() : ex.getCode(), ex.getMessage(), ex.getActionType()) : Result.error(ex.getCode() == null ? HttpStatus.INTERNAL_SERVER_ERROR.value() : ex.getCode(), ex.getMessage());
    }

  /*  @ExceptionHandler({RemotingException.class})
    public Result dubboRemotingException(RemotingException remotingException, HttpServletResponse response, HttpServletRequest request) {
        if (this.active.equals("prd")) {
            log.error(LogMark.format("rest_exception", "DubboRemotingException request url：{}，request method：{}"), new Object[]{request.getRequestURI(), request.getMethod(), remotingException});
        } else {
            log.error(remotingException.getMessage(), remotingException);
        }

        response.setStatus(HttpStatus.OK.value());
        return Result.error(900000000, "服务网络异常");
    }*/

    @ExceptionHandler({Exception.class})
    public Result unknownException(Exception ex, HttpServletResponse response, HttpServletRequest request) {
        if (this.active.equals("prd")) {
            log.error(LogMark.format("rest_exception", "UnknownException request url：{}，request method：{}"), new Object[]{request.getRequestURI(), request.getMethod(), ex});
        } else {
            log.error(ex.getMessage(), ex);
        }

        String errorMessage = ex.getMessage();
        if (ObjectUtil.isNotEmpty(errorMessage) && (errorMessage.contains("Exception") || errorMessage.length() > 50)) {
            errorMessage = "歇一歇,再试试";
        }

        response.setStatus(HttpStatus.OK.value());
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
    }

}
