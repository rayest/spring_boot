package com.rayeston.thymeleaf;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@RestController
public class ThymeleafController {
    @RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
    public String thymeleaf(Model model){
        ThymeleafEntity single = new ThymeleafEntity("aa", 11);
        List<ThymeleafEntity> people = new ArrayList<>();
        ThymeleafEntity thymeleafEntity1 = new ThymeleafEntity("xx", 11);
        ThymeleafEntity thymeleafEntity2 = new ThymeleafEntity("yy", 22);
        ThymeleafEntity thymeleafEntity3 = new ThymeleafEntity("zz", 33);
        people.add(thymeleafEntity1);
        people.add(thymeleafEntity2);
        people.add(thymeleafEntity3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "thymeleaf";
    }
}
