package com.rayeston.jms.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;

/**
 * Created by lirui on 2017/9/24.
 */
@Configuration
public class ConnectFactoryConfiguration {
    public static final String url = "tcp://127.0.0.1:61616";

    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(url);
        return activeMQConnectionFactory;
    }

    @Bean
    public SingleConnectionFactory singleConnectionFactory() throws Exception {
        SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
        singleConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory());
        return singleConnectionFactory;
    }

    @Bean
    public ActiveMQQueue activeMQQueue() throws JMSException {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue();
        activeMQQueue.setPhysicalName("queue");
        return activeMQQueue;
    }

    @Bean
    public JmsTemplate jmsTemplate() throws Exception {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(singleConnectionFactory());
        return jmsTemplate;
    }
}
