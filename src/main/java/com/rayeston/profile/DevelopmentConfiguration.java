package com.rayeston.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

/**
 * Created by lirui on 2017/10/5.
 */
@Order(6)
@Configuration
@Profile("dev")
public class DevelopmentConfiguration implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("development profile");
    }
}
