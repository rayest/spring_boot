package com.rayeston.jms.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/9/24.
 */
@RestController
public class ProducerController {

    public static final String message = "test-message";
    public static final String ok = "ok";

    @Resource
    private ProducerService producerService;

    @RequestMapping(value = "/producer", method = RequestMethod.GET)
    public String testProducer(){
        producerService.sendMessage(message);
        return ok;
    }
}
