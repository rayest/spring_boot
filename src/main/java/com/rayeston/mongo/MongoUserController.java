package com.rayeston.mongo;

import io.swagger.annotations.Api;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/11/12.
 */
@Api("MongoDB, 需要配置MongoDB数据库，否则会报错 connect")
@RestController
public class MongoUserController {

    @Resource
    private MongoUserService mongoUserService;

    @RequestMapping(value = "/mongo", method = RequestMethod.POST)
    public HttpEntity create(@RequestBody MongoUser mongoUser) {
        return mongoUserService.create(mongoUser);
    }
}
