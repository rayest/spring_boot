package com.rayeston.redis;

import com.rayeston.foundation.Response;
import com.rayeston.foundation.SequenceNumberService;
import com.rayeston.foundation.redis.RedisUtils;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.rayeston.foundation.redis.RedisUtils.THIRTY_MINUTES;

/**
 * Created by lirui on 2017/11/8.
 */
@Service
public class RedisService {

    @Resource
    private RedisUtils redisUtils;

    public HttpEntity create(RedisEntity redisEntity) {
        String key = redisEntity.getKey();
        String value = SequenceNumberService.generateUuid();
        System.out.println(value);
        redisUtils.set(key, value, THIRTY_MINUTES);
        String foundValue = (String) redisUtils.get(key);
        System.out.println(foundValue);
        redisEntity.setValue(foundValue);
        return Response.build(redisEntity);
    }

    public HttpEntity getByKey(String key) {
        String foundValue = (String) redisUtils.get(key);
        RedisEntity redisEntity = new RedisEntity();
        redisEntity.setValue(foundValue);
        redisEntity.setKey(key);
        return Response.build(redisEntity);
    }
}
