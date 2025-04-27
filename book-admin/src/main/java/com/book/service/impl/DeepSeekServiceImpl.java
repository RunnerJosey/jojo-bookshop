package com.book.service.impl;

import com.book.request.DeepSeekRequest;
import com.book.response.DeepSeekResponse;
import com.book.service.DeepSeekService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
@Service
@Slf4j
public class DeepSeekServiceImpl implements DeepSeekService {
    @Value("${deepseek.api.key}")
    private String apiKey;

    @Value("${deepseek.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String callDeepSeek(String userMessage) {
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);

        // 构建请求体
        DeepSeekRequest request = new DeepSeekRequest();
        request.setModel("deepseek-chat");
        DeepSeekRequest.Message message = new DeepSeekRequest.Message();
        message.setRole("user");
        message.setContent(userMessage);
        request.setMessages(Arrays.asList(message));

        log.info("请求头组装完毕，开始请求deepseek: ",request);
        HttpEntity<DeepSeekRequest> entity = new HttpEntity<>(request, headers);
        // 发送请求
        try {
            ResponseEntity<DeepSeekResponse> response = restTemplate.exchange(
                    apiUrl, HttpMethod.POST, entity, DeepSeekResponse.class);

            log.info("deepseek返回内容：", response.getBody());
            // 解析响应
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody().getChoices().get(0).getMessage().getContent();
            } else {
                throw new RuntimeException("Failed to call DeepSeek API: " + response.getStatusCode());
            }

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.PAYMENT_REQUIRED) {
                log.error("API 调用失败，账户余额不足: {}", e.getResponseBodyAsString());
                // 可以在这里添加通知管理员或其他处理逻辑
            } else {
                log.error("API 调用失败: {}", e.getMessage());
            }
            throw e;
        }

    }
}
