package com.book.utils;

import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求信息工具类
 */
@Component
public class HttpRequestUtil {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService usersService;

    public String getCurrentUserName() {
        String token = httpServletRequest.getHeader("Authorization");
        //去掉Bearer 前缀
        token = token.substring(7);
        //解析jwt 令牌，是否能解析通过
        if (jwtUtil.validateToken(token)) {
            //解析获取用户名
            String username = jwtUtil.getUsernameFromToken(token);
            //根据用户名获取用户信息
            UserDetails userDetails = usersService.loadUserByUsername(username);
            return username;
        }
        return null;
    }

}
