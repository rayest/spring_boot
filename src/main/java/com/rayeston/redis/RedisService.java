package com.rayeston.redis;

import com.rayeston.foundation.RedisUtils;
import com.rayeston.foundation.Response;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

import static com.rayeston.foundation.RedisUtils.THIRTY_MINUTES;

/**
 * Created by lirui on 2017/11/8.
 */
@Service
public class RedisService {

    @Resource
    private RedisUtils redisUtils;

    public HttpEntity create(Redis redis) {
        String key = redis.getKey();
        String value = UUID.randomUUID().toString();
        redisUtils.set(key, value, THIRTY_MINUTES);
        String foundValue = redisUtils.get(key);
        return Response.build(foundValue);
    }

}
