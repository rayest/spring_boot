package com.rayeston.freemarker;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lirui on 2017/10/2.
 */
@Service("freemarker")
public class FreemarkerService {

    public String getUsers(ModelMap modelMap) {
        modelMap.put("username", "root");
        modelMap.put("userList", getUserList());
        return "freemarkerUser";
    }

    private Object getUserList() {
        List<FreemarkerUser> freemarkerUserList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FreemarkerUser freemarkerUser = new FreemarkerUser();
            freemarkerUser.setName("用户 " + i);
            freemarkerUserList.add(freemarkerUser);
        }
        return freemarkerUserList;

    }
}
