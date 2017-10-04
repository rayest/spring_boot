package com.rayeston.foundation;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by lirui on 2017/10/4.
 */
@Api("commandLineRunner")
@Order(1)
@Configuration
public class MyCommandLineRunner implements CommandLineRunner {

    @Value("${name}")
    private String name;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SpringApplication.run()方法被调用前执行，以初始化一些必要的操作");
        System.out.println(this.name);
    }
}
