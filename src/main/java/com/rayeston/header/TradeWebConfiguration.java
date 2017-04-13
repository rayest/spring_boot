package com.rayeston.header;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by lirui on 2017/3/12.
 */
@EnableWebMvc
@Configuration
@Import(TradeViewConfiguration.class)
public class TradeWebConfiguration {

    @Bean
    public TradeController tradeController() {
        return new TradeController();
    }
}
