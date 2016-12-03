package com.rayeston.prefix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
@RestController
public class RayestController {
    @Autowired
    private Rayest rayest;

    @RequestMapping(value = "/rayest", method = RequestMethod.GET)
    public Rayest getRayest() {
        rayest.setName(rayest.getName());
        rayest.setAge(rayest.getAge());
        return rayest;
    }
}
