package com.rayeston.h2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/10/5.
 */
@RestController
public class H2UserController {

    @Resource
    private H2UserRepository h2UserRepository;

    @RequestMapping(value = "/h2/user/id/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public H2User findById(@PathVariable("id") Long id) {
        return h2UserRepository.findOne(id);
    }
}
