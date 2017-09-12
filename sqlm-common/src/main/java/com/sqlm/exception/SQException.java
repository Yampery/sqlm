package com.sqlm.exception;

/**
 * @decription SQException
 * <p>自定义业务异常</p>
 * @author Yampery
 * @date 2017/9/12 10:01
 */
public class SQException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public SQException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public SQException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public SQException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public SQException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
