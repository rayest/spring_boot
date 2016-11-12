package com.rayeston.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/11/12 0012.
 */
@RestController
public class UserController {
    @Autowired
    private User user;

    @RequestMapping("/user")
    public String userInfo() {
        return "userName: " + user.getUserName() + ", password: " + user.getPassword();
    }

}
