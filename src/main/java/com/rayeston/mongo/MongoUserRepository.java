package com.rayeston.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lirui on 2017/11/12.
 */
@Repository
public interface MongoUserRepository extends MongoRepository<MongoUser, Long> {
}
