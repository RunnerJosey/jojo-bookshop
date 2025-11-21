package com.book.exception;

import com.book.common.CommonResult;
import com.book.enums.BusinessErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    // 处理业务异常
    @ExceptionHandler(BusinessException.class)
    public CommonResult<?> handleBusinessException(BusinessException e) {
        log.error("业务异常：{}", e.getMessage());
        return CommonResult.failed(e.getCode(), e.getMessage());
    }

    /**
     * 参数校验异常，配合@Valid 失败使用
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return CommonResult.failed(BusinessErrorCodeEnum.VALIDATE_FAILED, ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    // 处理所有未捕获的异常
    @ExceptionHandler(Exception.class)
    public CommonResult<?> handleGlobalException(Exception e) {
        // 记录日志（生产环境需脱敏）
        log.error("系统异常：", e);
        return CommonResult.failed(BusinessErrorCodeEnum.FAILED, e.getMessage());
    }
}
