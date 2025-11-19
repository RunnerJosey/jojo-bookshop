package com.book.common;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCodeEnum implements IErrorCode {
    SUCCESS(200, "success"),//操作成功
    FAILED(500, "failed"),//操作失败
    VALIDATE_FAILED(404, "validate_failed"),//参数检验失败
    UNAUTHORIZED(401, "unauthorized"),//暂未登录或token已经过期
    FORBIDDEN(403, "forbidden");//没有相关权限
    private int code;
    private String message;

    private ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
