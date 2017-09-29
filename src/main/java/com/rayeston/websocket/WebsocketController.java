package com.rayeston.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lirui on 2017/9/28.
 */
@RestController
public class WebsocketController {
    private Logger logger = LoggerFactory.getLogger(WebsocketController.class);
    @Autowired
    private WebsocketService wsMessageService;

    @RequestMapping(value = "/websocket", method = RequestMethod.GET)
    public String createMessage(@RequestParam(value = "userId", required = true) Long userId, @RequestParam(value = "message", required = true) String message) {
        logger.debug("收到发送请求，向用户{}的消息：{}", userId, message);
        if (wsMessageService.sendToAllTerminal(userId, message)) {
            return "发送成功";
        } else {
            return "发送失败";
        }
    }

}
