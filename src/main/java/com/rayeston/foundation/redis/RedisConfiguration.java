package com.rayeston.foundation.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by lirui on 2017/11/9.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 30)
public class RedisConfiguration {

    @Autowired
    private Redis redis;

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate redisTemplate = new StringRedisTemplate(factory);
//        setSerializer(redisTemplate);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory factory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redis.getHostname());
        factory.setPassword(redis.getPassword());
        factory.setPort(redis.getPort());
        factory.setTimeout(redis.getTimeout());
        factory.setDatabase(redis.getDatabase());
        return factory;
    }
}
