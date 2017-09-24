package com.rayeston;

import com.rayeston.jms.producer.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lirui on 2017/9/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class jmsTest {

    @Resource
    private ProducerService producerService;

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 133; i++) {
            producerService.sendMessage("这是消息" + i);
        }
    }
}
