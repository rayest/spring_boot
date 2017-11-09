package com.rayeston.redis;

import io.swagger.annotations.Api;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public HttpEntity create(@RequestBody Redis redis){
        return redisService.create(redis);
    }
}
