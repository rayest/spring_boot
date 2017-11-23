package com.rayeston.exception;

import org.springframework.test.util.ReflectionTestUtils;

/**
 * Created by lirui on 2017/5/9.
 */
public class BusinessException extends RuntimeException {
    private String token;
    protected String code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Object codeObject) {
        super((String) ReflectionTestUtils.getField(codeObject, "message"));
        this.code = (String) ReflectionTestUtils.invokeGetterMethod(codeObject, "code");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
