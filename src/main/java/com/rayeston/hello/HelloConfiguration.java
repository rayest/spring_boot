package com.rayeston.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
public class HelloConfiguration {
    @Autowired
    private HelloProperties helloProperties;

    @Bean
    @ConditionalOnClass(HelloService.class)
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg(helloProperties.getMsg());
        return helloService;
    }
}
