package com.rayeston.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@Controller
@SpringBootApplication
public class ThymeleafApplication {
    @RequestMapping("/")
    public String index(Model model){
        ThymeleafPersonEntity single = new ThymeleafPersonEntity("aa", 11);
        List<ThymeleafPersonEntity> people = new ArrayList<ThymeleafPersonEntity>();
        ThymeleafPersonEntity thymeleafPersonEntity1 = new ThymeleafPersonEntity("xx", 11);
        ThymeleafPersonEntity thymeleafPersonEntity2 = new ThymeleafPersonEntity("yy", 22);
        ThymeleafPersonEntity thymeleafPersonEntity3 = new ThymeleafPersonEntity("zz", 33);
        people.add(thymeleafPersonEntity1);
        people.add(thymeleafPersonEntity2);
        people.add(thymeleafPersonEntity3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }
}
