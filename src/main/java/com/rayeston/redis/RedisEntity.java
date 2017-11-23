package com.rayeston.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lirui on 2017/11/8.
 */
@Data
public class RedisEntity implements Serializable{
    private static final long serialVersionUID = 8298995919916566210L;
    private String key;
    private String value;
}
