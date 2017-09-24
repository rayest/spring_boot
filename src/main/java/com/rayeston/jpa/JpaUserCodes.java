package com.rayeston.jpa;

/**
 * Created by lirui on 2017/9/24.
 */
public enum JpaUserCodes {

    JPA_USER_IS_NOT_EXISTED("1001", "用户不存在");

    private String code;
    private String message;

    JpaUserCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
