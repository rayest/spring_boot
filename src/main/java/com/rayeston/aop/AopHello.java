package com.rayeston.aop;

public class AopHello {
    private void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        AopHello h = new AopHello();
        h.sayHello();
    }
}
