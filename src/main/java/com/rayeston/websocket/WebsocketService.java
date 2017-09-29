package com.rayeston.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by lirui on 2017/9/28.
 */
@Service("webSocketService")
public class WebsocketService {
    private Logger logger = LoggerFactory.getLogger(WebsocketService.class);
    private WebsocketDemo websocketDemo = new WebsocketDemo();

    public Boolean sendToAllTerminal(Long userId, String message) {
        logger.debug("向用户{}的消息：{}", userId, message);
        if (websocketDemo.sendMessageToUser(userId, message)) {
            return true;
        } else {
            return false;
        }
    }


}
