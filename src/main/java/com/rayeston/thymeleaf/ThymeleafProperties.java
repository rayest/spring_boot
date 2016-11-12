package com.rayeston.thymeleaf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Rayest on 2016/11/12 0012.
 */
@ConfigurationProperties("spring.thymeleaf")
public class ThymeleafProperties {
    public static final String DEFAULT_PREFIX = "classpath:/templates/";
    public static final String DEFAULT_SUFFIX = ".html";

    private String prefix = DEFAULT_PREFIX;
    private String suffix = DEFAULT_SUFFIX;

    // 模板模式设置，以下为默认设置
    private String model = "HTML5";
    private String encoding = "UTF-8";
    private String contentType = "text/html";

    // 开启模板缓存，开发时设置为关闭
    private boolean cache = true;

}
