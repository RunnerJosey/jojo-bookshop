package com.book.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * redis 限流类 lua脚本
 */
@Component
public class RedisRateLimiter {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String LUA_SCRIPT =
            "local key = KEYS[1]\n" +
                    "local count = tonumber(redis.call('get', key) or 0)\n" +
                    "if count >= 5 then\n" +
                    "   return 0\n" +
                    "else\n" +
                    "   redis.call('INCR', key)\n" +
                    "   return 1\n" +
                    "end";

    public boolean allowRequest(String key) {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>(LUA_SCRIPT, Long.class);
        Long result = redisTemplate.execute(script, Collections.singletonList(key));
        return result != null && result == 1;
    }
}
