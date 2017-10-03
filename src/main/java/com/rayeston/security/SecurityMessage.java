package com.rayeston.security;

import io.swagger.annotations.Api;
import lombok.Data;

/**
 * Created by lirui on 2017/10/3.
 */
@Api("传值对象")
@Data
public class SecurityMessage {
    private String title;
    private String extraInfo;
    private String content;

    public SecurityMessage(String title, String extraInfo, String content) {
        this.title = title;
        this.extraInfo = extraInfo;
        this.content = content;
    }
}
