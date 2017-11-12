package com.rayeston.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lirui on 2017/8/13.
 */
public class CookieUtils {
    private static final String NAME = "token";
    static String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return null;
    }
}
