package com.book.controller;

import com.book.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping("/apple")
public class AppleController {

    @Autowired
    private RedisUtil redisUtil;



    @RequestMapping(value = "/redis", method = RequestMethod.POST)
    public void testRedis(){
        redisUtil.setValue("apple",123123);
        Object apple = redisUtil.getValue("apple");
        log.info("apple:  " + apple);
    }
    @RequestMapping(value = "/mysql", method = RequestMethod.POST)
    public void testMysql(){



    }



}
