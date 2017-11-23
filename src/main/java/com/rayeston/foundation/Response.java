package com.rayeston.foundation;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lirui on 2017/5/15.
 */
public class Response {

    private static final String OK_STATUS = "1000";

    private static HttpEntity postResponse(Object o) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(o);
    }

    private static HttpEntity buildResponse(Object o) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(o);
    }

    private static Map<String, Object> buildOkData(Object data) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", OK_STATUS);
        body.put("data", data);
        return body;
    }

    private static Map<String, Object> buildOkMessage(String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", OK_STATUS);
        body.put("message", message);
        return body;
    }

    public static HttpEntity post(Object data) {
        return Response.postResponse(Response.buildOkData(data));
    }

    public static HttpEntity post(String message) {
        return Response.postResponse(buildOkMessage(message));
    }

    public static HttpEntity build(String message) {
        return Response.buildResponse(buildOkMessage(message));
    }

    public static HttpEntity build(Object o) {
        return Response.buildResponse(buildOkData(o));
    }

}
