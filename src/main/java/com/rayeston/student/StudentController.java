package com.rayeston.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@RestController
public class StudentController {
    // 注入 application.properties 配置文件中的属性值 user.userName
    @Value("${student.studentName}")
    private String studentName;

    // 注入 application.properties 配置文件中的属性值 user.password
    @Value("${student.password}")
    private String password;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String loadStudent() {
        return "studentName: " + studentName + ", " + "password: " + password;
    }
}
