package com.rayeston.hello;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
public class HelloService {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String sayHello(){
        return "Hello, " + msg;
    }
}
