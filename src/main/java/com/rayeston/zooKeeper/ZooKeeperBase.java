package com.rayeston.zooKeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lirui on 2017/11/23.
 */
public class ZooKeeperBase {

    private static final String CONNECT_ADDRESS = "";
    private static final int SESSION_OUT_TIME = 5000;

    private static final CountDownLatch CONNECTED_SEMAPHORE = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_ADDRESS, SESSION_OUT_TIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                // 事件状态
                Event.KeeperState keeperState = watchedEvent.getState();
                // 事件类型
                Event.EventType eventType = watchedEvent.getType();
                // 如果是建立连接
                if (Event.KeeperState.SyncConnected == keeperState){
                    if (Event.EventType.None == eventType){
                        // 如果连接成功，发送信号量，阻塞程序的继续执行
                        CONNECTED_SEMAPHORE.countDown();
                        System.out.println("zk 建立连接");
                    }
                }
            }
        });

        // 阻塞
        CONNECTED_SEMAPHORE.await();

        System.out.println("执行了：。。。。");
    }
}
