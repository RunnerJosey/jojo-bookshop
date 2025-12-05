package com.book.filter;

import com.book.common.CommonResult;
import com.book.constant.BusinessConstant;
import com.book.utils.JwtUtil;
import com.book.enums.BusinessErrorCodeEnum;
import com.book.exception.BusinessException;
import com.book.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT认证过滤器
 */
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService usersService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        try{
            String requestURI = request.getRequestURI();
            if (requestURI.startsWith("/user/")) {
                chain.doFilter(request, response);
                return;
            }

            //从请求体中获取token
            String token = request.getHeader("Authorization");
            //验证token，跟数据库 用户名 和 密码 进行比对，并且验证redis是否过期
            if (token != null && token.startsWith("Bearer ")) {
                //去掉Bearer 前缀
                token = token.substring(7);
                //解析jwt 令牌，是否能解析通过
                if (jwtUtil.validateToken(token)) {
                    //解析获取用户名
                    String username = jwtUtil.getUsernameFromToken(token);
                    //根据用户名获取用户信息
                    UserDetails userDetails = usersService.loadUserByUsername(username);
                    //创建认证令牌 ，UsernamePasswordAuthenticationToken用于在认证过程中携带用户的凭证信息
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    //设置认证令牌
                    SecurityContextHolder.getContext().setAuthentication(authToken);

                }else {
                    throw new BusinessException(BusinessErrorCodeEnum.UNAUTHORIZED);
                }
            }else {
                throw new BusinessException(BusinessErrorCodeEnum.UNAUTHORIZED);
            }
            //放行
            chain.doFilter(request, response);
        } catch (AuthenticationException e){
            //直接在过滤器中处理认证异常
            handleAuthenticationException(response, e);
        } catch (Exception e){
            //处理其他业务异常
            handleBusinessException(response, e);
        }
    }

    private void handleAuthenticationException(HttpServletResponse response, AuthenticationException e)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");

        CommonResult<?> result = CommonResult.failed(BusinessErrorCodeEnum.UNAUTHORIZED,e.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        //不能直接返回通用错误信息CommonResult，这里封装一下
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

    private void handleBusinessException(HttpServletResponse response, Exception e)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setContentType("application/json;charset=UTF-8");

        CommonResult<?> result = CommonResult.failed(BusinessErrorCodeEnum.FAILED,e.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        //不能直接返回通用错误信息CommonResult，这里封装一下
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
