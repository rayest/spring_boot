package com.rayeston.jpa;

/**
 * Created by lirui on 2017/9/24.
 */
public enum JpaUserCodes {

    JPA_USER_IS_NOT_EXISTED("1001", "用户不存在"),
    JPA_USERS_EMPTY("1002", "没有用户"),
    JPA_USER_DELETE_SUCCESSFUL("1003", "用户删除成功"),
    JPA_USER_DELETE_FAILED("1004", "用户删除失败");

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
