package com.rayeston.jpa;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public JpaUser createJpaUser(@RequestBody JpaUser jpaUser) {
        return jpaService.createJpaUser(jpaUser);
    }

    @RequestMapping(value = "/jpa/jpaUser/name/{name}", method = RequestMethod.GET)
    public JpaUser getByName(@PathVariable("name") String name) throws Exception {
        return jpaService.getByName(name);
    }

    @RequestMapping(value = "/jpa/jpaUser/age/{age}", method = RequestMethod.GET)
    public JpaUser getByAge(@PathVariable("age") Integer age) throws Exception {
        return jpaService.getByAge(age);
    }

    @RequestMapping(value = "/jpa/jpaUser/name/{name}/age/{age}", method = RequestMethod.GET)
    public JpaUser getByNameAndAge(@PathVariable("name") String name, @PathVariable("age") Integer age) throws Exception {
        return jpaService.getByNameAndAge(name, age);
    }

    @RequestMapping(value = "/jpa/jpaUsers", method = RequestMethod.GET)
    public List<JpaUser> getAll() throws Exception {
        return jpaService.getAll();
    }

    @RequestMapping(value = "/jpa/jpaUser/id/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
        return jpaService.deleteById(id);
    }

    @RequestMapping(value = "/jpa/jpaUser/id/{id}", method = RequestMethod.PUT)
    public JpaUser updateById(@PathVariable("id") Long id, @RequestBody JpaUser jpaUser){
        return jpaService.updateById(id, jpaUser);
    }


}
