package com.rayeston.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lirui on 2017/10/5.
 */
//@RestController
public class HttpErrorHandler implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @Override
    public String getErrorPath()  {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorHtml(HttpServletRequest request) {
        return "404";
    }

    @RequestMapping(value = ERROR_PATH)
    public Object error(HttpServletRequest request) {
        return "404";
    }

}
