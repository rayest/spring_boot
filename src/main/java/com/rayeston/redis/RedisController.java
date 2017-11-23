package com.rayeston.redis;

import io.swagger.annotations.Api;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/11/8.
 */
@Api("spring-redisTemplate 的使用")
@RestController
public class RedisController {

    @Resource
    private RedisService redisService;

    @RequestMapping(value = "/redis", method = RequestMethod.POST)
    public HttpEntity create(@RequestBody RedisEntity redisEntity) {
        return redisService.create(redisEntity);
    }

    @RequestMapping(value = "/redis/key/{key}", method = RequestMethod.GET)
    public HttpEntity getByKey(@PathVariable("key") String key) {
        return redisService.getByKey(key);
    }

}
