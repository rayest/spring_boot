package com.rayeston.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by lirui on 2017/10/5.
 */
@RestController
public class MockController {
    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    @RequestMapping(value = "/exception/base", method = RequestMethod.GET)
    public Object throwBaseException() throws Exception {
        throw new BaseException("This is BaseException.");
    }

    @RequestMapping("/exception/one")
    public Object throwMyException1() throws Exception {
        throw new MyException1("This is MyException1.");
    }

    @RequestMapping("/exception/two")
    public Object throwMyException2() throws Exception {
        throw new MyException2("This is MyException2.");
    }

    @RequestMapping("/exception/io")
    public Object throwIOException() throws Exception {
        throw new IOException("This is IOException.");
    }

    @RequestMapping("/exception/null")
    public Object throwNullPointerException() throws Exception {
        throw new NullPointerException("This is NullPointerException.");
    }

}
