package com.book.enums;

/**
 * 支付渠道枚举
 */

public enum PayChannelEnum {
    WECHAT_PAY(1, "微信支付", "wechat_pay"),
    ALIPAY(2, "支付宝", "alipay"),
    UNION_PAY(3, "银联", "union_pay");

    private final Integer code;
    private final String name;
    private final String channelCode;


    PayChannelEnum(Integer code, String name, String channelCode) {
        this.code = code;
        this.name = name;
        this.channelCode = channelCode;
    }


}
