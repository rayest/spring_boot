package com.rayeston.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@Controller
public class ThymeleafController {
    @RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
    public String thymeleaf(Model model){
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        Person person1 = new Person("xx", 11);
        Person person2 = new Person("yy", 22);
        Person person3 = new Person("zz", 33);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "thymeleaf";
    }
}
