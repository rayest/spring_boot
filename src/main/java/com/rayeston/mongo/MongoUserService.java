package com.rayeston.mongo;

import com.rayeston.foundation.Response;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/11/12.
 */
@Service
public class MongoUserService {

    @Resource
    private MongoUserRepository mongoUserRepository;

    public HttpEntity create(MongoUser mongoUser) {
        MongoUser savedMongoUser = mongoUserRepository.save(mongoUser);
        return Response.build(savedMongoUser);
    }
}
