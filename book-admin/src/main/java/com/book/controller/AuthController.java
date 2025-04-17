package com.book.controller;

import com.book.request.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import com.book.common.CommonResult;

import static com.book.common.CommonResult.failed;
import static com.book.common.CommonResult.success;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {

    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginRequest loginRequest) {
        log.info("登录:",loginRequest.toString());
        // 这里可以添加实际的登录逻辑，例如验证用户名和密码
        if ("admin".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            log.info("登录成功");
            Map tokenMap = new HashMap();
            tokenMap.put("token","token");
            return success(tokenMap);
        } else {
            log.info("登录失败");
            Map tokenMap = new HashMap();
            tokenMap.put("token","token");
            return failed("登录失败");
        }
    }
    // 处理 OPTIONS 请求
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().build();
    }

}


