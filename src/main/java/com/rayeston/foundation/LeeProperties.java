package com.rayeston.foundation;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lirui on 2017/10/5.
 */
@Data
@ConfigurationProperties("lee")
@PropertySource("classpath:config/application.properties")
@Configuration
@Validated
public class LeeProperties {

    @NotNull
    private boolean enabled;

    @NotNull
    private InetAddress remoteAddress;

    @Valid
    private Security security = new Security();

    @Data
    public static class Security {

        @NotEmpty
        private String username;

        @NotEmpty
        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

    }

    public LeeProperties() {
        this.enabled = enabled;
        this.remoteAddress = remoteAddress;
        this.security = security;
    }
}
