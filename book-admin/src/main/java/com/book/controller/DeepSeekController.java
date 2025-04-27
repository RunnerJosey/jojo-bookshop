package com.book.controller;

import com.book.service.DeepSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("deepseek")
public class DeepSeekController {
    @Autowired
    private DeepSeekService deepSeekService;

    @PostMapping("/chat")
    public String chat(@RequestParam String message) {
        return deepSeekService.callDeepSeek(message);
    }

}
