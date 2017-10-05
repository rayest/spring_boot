package com.rayeston.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

/**
 * Created by lirui on 2017/10/5.
 */
@Order(5)
@Configuration
@Profile("production")
public class ProductionConfiguration implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("production profile");
    }
}
