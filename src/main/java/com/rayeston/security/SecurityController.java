package com.rayeston.security;

import io.swagger.annotations.Api;
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
    
}
