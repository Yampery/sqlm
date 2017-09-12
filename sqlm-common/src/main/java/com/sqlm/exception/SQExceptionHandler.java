package com.sqlm.exception;

import com.sqlm.pojo.ResponsePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @decription SQExceptionHandler
 * <p>业务异常处理器</p>
 * @author Yampery
 * @date 2017/9/12 10:03
 */
public class SQExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler(SQException.class)
    public ResponsePojo handleRRException(SQException e){
        ResponsePojo r = ResponsePojo.build(e.getCode(), e.getMsg());
        return r;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponsePojo handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return ResponsePojo.error("数据库中已存在该记录");
    }

    /*@ExceptionHandler(AuthorizationException.class)
    public ResponsePojo handleAuthorizationException(AuthorizationException e){
        logger.error(e.getMessage(), e);
        return ResponsePojo.error("没有权限，请联系管理员授权");
    }*/

    @ExceptionHandler(Exception.class)
    public ResponsePojo handleException(Exception e){
        logger.error(e.getMessage(), e);
        return ResponsePojo.error("未知异常，请联系管理员");
    }
}