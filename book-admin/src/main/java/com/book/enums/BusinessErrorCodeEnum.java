package com.book.enums;

import com.book.common.IErrorCode;

public enum BusinessErrorCodeEnum implements IErrorCode {

    //系统通用错误
    SUCCESS(200, "操作成功"),
    FAILED(500, "系统异常"),
    VALIDATE_FAILED(404, "参数检验失败"),

    // 用户模块错误 10000-10099
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    USER_NOT_FOUND(10000, "用户不存在"),
    USER_DISABLED(10001, "用户已被禁用"),
    USER_PASSWORD_ERROR(10002, "用户密码错误"),

    // 订单模块错误 10100-10199
    ORDER_NOT_FOUND(10100, "订单不存在"),
    ORDER_STATUS_ERROR(10101, "订单状态错误"),
    ORDER_AMOUNT_ERROR(10102, "订单金额错误");


    private final Integer code;
    private final String message;

    BusinessErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
