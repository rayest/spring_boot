package com.rayeston.security;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lirui on 2017/10/3.
 */
@Api("spring-security")
@RestController
public class SecurityController {

    @RequestMapping(value = "/security/hello", method = RequestMethod.GET)
    public String sayHelloToSecurity(){
        return "Hello security";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/security/authentication", method = RequestMethod.GET)
    public String enterIfAuthorized(){
        return "Entered for authorized ";
    }

    @RequestMapping(value = "/security/message", method = RequestMethod.GET)
    public String getMessage(Model model){
        SecurityMessage message = new SecurityMessage("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", message);
        return "securityLoginOk";
    }
}
