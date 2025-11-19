package com.book.exception;


import com.book.common.IErrorCode;

/**
 * 业务异常
 */
public class BusinessException  extends  RuntimeException{

    private  Integer code;
    private  String message;
    private  Object data;

    public BusinessException(Integer code, String message) {
        this(code, message, null);
    }

    public BusinessException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BusinessException(IErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public BusinessException(IErrorCode errorCode, Object data) {
        this(errorCode.getCode(), errorCode.getMessage(), data);
    }

    // Getters
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
