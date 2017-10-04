package com.rayeston.foundation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

/**
 * Created by lirui on 2017/10/5.
 */
@Order(3)
@PropertySource("classpath:config/application.properties")
@Configuration
@ConfigurationProperties("ray")
public class RayCommandLineRunner implements CommandLineRunner {

    @Value("${id}")
    private String id;

    @Value("${name}")
    private String name;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("ray: " + this.id);
        System.out.println("ray: " + this.name);
    }
}
