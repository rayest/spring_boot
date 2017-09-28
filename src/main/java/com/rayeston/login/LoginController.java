package com.rayeston.login;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lirui on 2017/8/13.
 */
@Api("登录")
@RestController
public class LoginController {

    @ApiOperation("")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        String token = CookieUtils.getCookie(request);
        return token;
    }
}
