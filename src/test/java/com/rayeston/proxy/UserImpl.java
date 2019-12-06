package com.rayeston.proxy;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-06-04
 *  Time: 上午11:34
 *  Description:
 **/
public class UserImpl implements UserInterface {

    @Override
    public String getDefaultName() {
        System.out.println("Default name is Lee");
        return "Lee";
    }

    @Override
    public String getNameById(String id) {
        System.out.println("Id is: " + id);
        return "Rayest";
    }
}
