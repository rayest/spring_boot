package com.rayeston.zooKeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by lirui on 2017/11/20.
 */
@RestController
public class ZooKeeperController {

    @RequestMapping(value = "/zooKeeper", method = RequestMethod.GET)
    public String get() throws IOException, KeeperException, InterruptedException {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("received event: " + watchedEvent);
            }
        };
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 999999, watcher);
        byte[] data = zooKeeper.getData("/node_1", watcher, null);
        String value = new String(data);
        zooKeeper.close();
        return "value got from zookeeper: " + value;
    }
}
