package com.rayeston.foundation;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lirui on 2017/11/8.
 */
public class Response {

    private static final String OK_STATUS = "1000";

    public static HttpEntity build(Object object) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", OK_STATUS);
        body.put("data", object);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }
}
