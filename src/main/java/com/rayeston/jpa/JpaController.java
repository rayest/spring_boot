package com.rayeston.jpa;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/9/24.
 */
@Api("spring-data-jpa")
@RestController
public class JpaController {

    @Resource
    private JpaService jpaService;

    @RequestMapping(value = "/jpa/jpaUser/id/{id}", method = RequestMethod.GET)
    public JpaUser getById(@PathVariable("id") Long id) throws Exception {
        return jpaService.getById(id);
    }

    @RequestMapping(value = "/jpa/jpaUser", method = RequestMethod.POST)
    public JpaUser createJpaUser(@RequestBody JpaUser jpaUser){
        return jpaService.createJpaUser(jpaUser);
    }
}
