package com.rayeston.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@ConfigurationProperties
public class HelloProperties {
    private static final String MSG = "world";
    private String msg = MSG;

    public static String getMSG() {
        return MSG;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
