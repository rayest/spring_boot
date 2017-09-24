package com.rayeston.jms.consumer;

import io.swagger.annotations.ApiOperation;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.JMSException;

/**
 * Created by lirui on 2017/9/24.
 */
@Configuration
public class ConsumerConfiguration {
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

    @ApiOperation("如果是主题模式需要修改为 new ActiveMQTopic()")
    @Bean
    public ActiveMQQueue activeMQQueue() throws JMSException {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue();
        activeMQQueue.setPhysicalName("queue");
        return activeMQQueue;
    }

    @Bean
    public ConsumerMessageListener consumerMessageListener(){
        return new ConsumerMessageListener();
    }

    @Bean
    public DefaultMessageListenerContainer listenerContainer() throws Exception {
        DefaultMessageListenerContainer listenerContainer = new DefaultMessageListenerContainer();
        listenerContainer.setConnectionFactory(singleConnectionFactory());
        listenerContainer.setDestination(activeMQQueue());
        listenerContainer.setMessageListener(consumerMessageListener());
        return listenerContainer;
    }
}
