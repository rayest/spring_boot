package com.rayeston.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class AopApplication {

    @Resource
    private AopPerson aopChinese;

    @RequestMapping("/aop/test")
    public void test() {
        aopChinese.sayHello("listen");
        System.out.println(aopChinese.getClass());
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
}
