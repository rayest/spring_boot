package com.rayeston.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lirui on 2017/9/28.
 */

@ServerEndpoint(value = "/websocketDemo/{userId}", configurator = SpringConfigurator.class)
public class WebsocketDemo {

    private Logger logger = LoggerFactory.getLogger(WebsocketDemo.class);

    private static int onlineCount = 0;
    private static Map<Long, Set<WebsocketDemo>> userSocket = new HashMap<>();
    private Session session;
    private Long userId;

    @OnOpen
    public void onOpen(@PathParam("/userId") Long userId, Session session) {
        this.session = session;
        this.userId = userId;
        onlineCount++;
        if (userSocket.containsKey(this.userId)) {
            userSocket.get(this.userId).add(this);
        } else {
            Set<WebsocketDemo> addedUserSet = new HashSet<>();
            addedUserSet.add(this);
            userSocket.put(this.userId, addedUserSet);
        }
    }

    @OnClose
    public void onClose() {
        if (userSocket.get(this.userId).size() == 0) {
            userSocket.remove(this.userId);
        } else {
            userSocket.get(this.userId).remove(this);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.debug("收到来自用户id为：{}的消息：{}", this.userId, message);
        if (session == null) {
            logger.debug("session null");
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.debug("用户id为：{}的连接发送错误", this.userId);
        error.printStackTrace();
    }

    public Boolean sendMessageToUser(Long userId, String message) {
        if (userSocket.containsKey(userId)) {
            logger.debug(" 给用户id为：{}的所有终端发送消息：{}", userId, message);
            for (WebsocketDemo websocketDemo : userSocket.get(userId)) {
                logger.debug("sessionId为:{}", websocketDemo.session.getId());
                try {
                    websocketDemo.session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.debug(" 给用户id为：{}发送消息失败", userId);
                    return false;
                }
            }
            return true;
        }
        logger.debug("发送错误：当前连接不包含id为：{}的用户", userId);
        return false;
    }


}
