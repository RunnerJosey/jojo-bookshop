package com.book.constant;

/**
 * 系统常量
 */
public class BusinessConstant {

    //redis token 前缀
    public static final String TOKEN_PREFIX = "login:success:";
    //JWT 密钥
    public static final byte[] SECRET_KEY = "eW91ci0yNTYtYml0LXNlY3JldC1zZWNyZXQteHh4eHh4eHh4eHh4eHh4eHg=".getBytes();
    //JWT 过期时间 redis token 过期时间 1天，毫秒单位
    public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 ;

}
