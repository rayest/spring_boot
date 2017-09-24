package com.rayeston.jms.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.TextMessage;

/**
 * Created by lirui on 2017/9/24.
 */
@Service
public class ProducerService {

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private ActiveMQQueue activeMQQueue;

    public void sendMessage(String message) {
        jmsTemplate.send(activeMQQueue, session -> {
            TextMessage textMessage = session.createTextMessage(message);
            return textMessage;
        });
        System.out.println("发送消息" + message);
    }
}
