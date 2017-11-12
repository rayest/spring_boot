package com.rayeston.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lirui on 2017/10/5.
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    @ExceptionHandler(value = BaseException.class)
    public Object baseErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("---BaseException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("error: " + e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(NullPointerException.class)
    public String controllerExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("---ControllerException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return e.getMessage();
    }
}
