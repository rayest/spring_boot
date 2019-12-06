package com.rayeston.aop;

import org.springframework.stereotype.Component;

@Component
public class AopChinese implements AopPerson {

    @Timer
    @Override
    public String sayHello(String name) {
        System.out.println("-- sayHello() --");
        return name + " 你好, AOP";
    }

    public void eat(String food) {
        System.out.println("我正在吃：" + food);
    }
}
