package com.rayeston.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by lirui on 2017/9/29.
 */
@Controller
public class FreemarkerController {

    private String message = "Hello World";

    @RequestMapping(value = "/freemarker", method = RequestMethod.GET)
    public String showFreemarker(ModelMap modelMap){
        modelMap.put("time", new Date());
        modelMap.put("message", this.message);
        return "hello";
    }
}
