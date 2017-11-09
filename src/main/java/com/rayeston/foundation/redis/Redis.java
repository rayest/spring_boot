package com.rayeston.foundation.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lirui on 2017/11/9.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis", locations = "classpath:redis.properties")
public class Redis {
    private int database;
    private String hostname;
    private int port;
    private String password;
    private int timeout;
    private String maxIdle;
    private String minIdle;
    private String maxActive;
    private String maxWait;
}
