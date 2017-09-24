package com.rayeston.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by lirui on 2017/9/24.
 */
public class AppConsumer {
    public static final String url = "tcp://127.0.0.1:61616";
    public static final String queueName = "queue-test";
    public static final String textContent = "test";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageConsumer messageConsumer = session.createConsumer(destination);
        messageConsumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("接收消息"+ textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
//        connection.close();
    }
}
