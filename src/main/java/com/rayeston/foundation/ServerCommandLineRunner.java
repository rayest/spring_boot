package com.rayeston.foundation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lirui on 2017/10/5.
 */
@Order(2)
@ConfigurationProperties(prefix = "my")
@Configuration
public class ServerCommandLineRunner implements CommandLineRunner {

    private List<String> servers = new ArrayList<>();

    public List<String> getServers() {
        return this.servers;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(this.getServers());
    }
}
