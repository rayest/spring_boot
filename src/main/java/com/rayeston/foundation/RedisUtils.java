package com.rayeston.foundation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by lirui on 2017/11/8.
 */
@Component
public class RedisUtils {

    public static final long THIRTY_MINUTES = 30 * 60L;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void set(String key, String value, long time) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, time);
    }

    public String get(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
