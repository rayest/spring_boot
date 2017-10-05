package com.rayeston.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

/**
 * Created by lirui on 2017/10/5.
 */
@Order(4)
@Configuration
@EnableConfigurationProperties(LeeProperties.class)
@PropertySource("classpath:config/application.properties")
public class LeeCommandLineRunner implements CommandLineRunner {

    private LeeProperties leeProperties = new LeeProperties();

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(leeProperties.toString());
    }
}
