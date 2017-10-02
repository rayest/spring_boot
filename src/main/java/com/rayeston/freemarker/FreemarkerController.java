package com.rayeston.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lirui on 2017/9/29.
 */
@Controller
public class FreemarkerController {

    @Resource
    private FreemarkerService freemarkerService;

    @RequestMapping(value = "/freemarker/hello", method = RequestMethod.GET)
    public String showFreemarker(ModelMap modelMap){
        String message = "Hello World";
        modelMap.put("time", new Date());
        modelMap.put("message", message);
        return "hello";
    }

    @RequestMapping(value = "/freemarker/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap){
        return freemarkerService.getUsers(modelMap);
    }

    @RequestMapping(value = "/freemarker/type", method = RequestMethod.GET)
    public String getByType(ModelMap modelMap){
        return freemarkerService.getByType(modelMap);
    }

    @RequestMapping(value = "/freemarker/assign", method = RequestMethod.GET)
    public String getByDesign(ModelMap modelMap){
        return freemarkerService.getByDesign(modelMap);
    }
}
