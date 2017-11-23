package com.rayeston.foundation.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lirui on 2017/11/8.
 */
@SuppressWarnings("unchecked")
@Component
public class RedisUtils {

    public static final long THIRTY_MINUTES = 60 * 30L;

    @Autowired
    private RedisTemplate redisTemplate;

    public void set(final String key, String value, Long time) {
        ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    public Object get(final String key) {
        ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
