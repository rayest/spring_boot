package com.rayeston.proxy;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-06-04
 *  Time: 上午11:39
 *  Description:
 **/
public class UserProxy implements UserInterface {

    private UserInterface proxy;

    public UserProxy(UserInterface proxy) {
        this.proxy = proxy;
    }

    @Override
    public String getDefaultName() {
        System.out.println("Get default name by proxy: " + proxy.getDefaultName());
        return proxy.getDefaultName();
    }

    @Override
    public String getNameById(String id) {
        System.out.println("Get name by id, id is: " + id);
        return proxy.getNameById(id);
    }
}
