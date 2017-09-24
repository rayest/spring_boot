package com.rayeston.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by lirui on 2017/9/24.
 */

public class AppProducer {
    public static final String url = "tcp://127.0.0.1:61616";
    public static final String queueName = "queue-test";
    public static final String textContent = "test";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageProducer messageProducer = session.createProducer(destination);
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage(textContent + i);
            messageProducer.send(textMessage);
            System.out.println("发送消息" + textMessage.getText());
        }
        connection.close();
    }
}
