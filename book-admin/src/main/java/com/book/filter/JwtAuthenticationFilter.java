package com.book.filter;

import com.book.config.utils.JwtUtil;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT认证过滤器
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService usersService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        //从请求体中获取token
        String token = request.getHeader("Authorization");
        //验证token
        if (token != null && token.startsWith("Bearer ")) {
            //去掉Bearer 前缀
            token = token.substring(7);
            //解析jwt 令牌，是否能解析通过
            if (jwtUtil.validateToken(token)) {
                //解析获取用户名
                String username = jwtUtil.getUsernameFromToken(token);
                //根据用户名获取用户信息
                UserDetails userDetails = usersService.loadUserByUsername(username);
                //创建认证令牌
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                //设置认证令牌
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        //放行
        chain.doFilter(request, response);
    }
}
