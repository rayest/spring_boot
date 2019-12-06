package com.rayeston.zooKeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lirui on 2017/11/28.
 */
public class ZooKeeperWatcher implements Watcher {

    /**
     * 定义原子变量
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 定义失效时间
     */
    public static final int SESSION_TIMEOUT = 10000;

    /**
     * zk服务器地址
     */
    public static final String CONNECTION_ADDRESS = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";

    public static final String PARENT_PATH = "/p";
    public static final String CHILDREN_PATH = "/p/c";
    public static final String LOG_PREFIX_OF_MAIN = "【Main】";

    private ZooKeeper zooKeeper = null;

    /**
     * 用于等待zookeeper连接建立之后通知阻塞程序继续向下执行
     */
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public void createConnection(String connectionAddress, int sessionTimeout) {
        this.releaseConnection();
        try {
            zooKeeper = new ZooKeeper(connectionAddress, sessionTimeout, this);
            connectedSemaphore.await();
            System.out.println(LOG_PREFIX_OF_MAIN + "开始连接服务器");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void releaseConnection() {
        if (this.zooKeeper != null) {
            try {
                this.zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("进入process方法......event= " + watchedEvent);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (watchedEvent == null) {
            return;
        }
        // 事件状态
        Event.KeeperState keeperState = watchedEvent.getState();
        // 事件类型
        Event.EventType eventType = watchedEvent.getType();
        /* 受影响的路径*/
        String path = watchedEvent.getPath();
        // 原子对象 atomicInteger 记录进入process的次数
        String logPrefix = "【Watcher-" + this.atomicInteger.incrementAndGet() + "】";
        System.out.println(logPrefix + "收到watcher通知");
        System.out.println(logPrefix + "连接类型：" + keeperState.toString());
        System.out.println(logPrefix + "事件类型：" + eventType.toString());
        if (keeperState == Event.KeeperState.SyncConnected) {
            // 成功连接了服务器
            if (Event.EventType.None == eventType) {
                System.out.println(logPrefix + "成功连接了服务器");
                connectedSemaphore.countDown();
            } else if (Event.EventType.NodeCreated == eventType) {
                System.out.println(logPrefix + "节点创建");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (Event.EventType.NodeDataChanged == eventType) {
                System.out.println(logPrefix + "节点数据更新");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (eventType == Event.EventType.NodeChildrenChanged) {
                System.out.println(logPrefix + "子节点数据更新");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (eventType== Event.EventType.NodeDeleted){
                System.out.println(logPrefix + "节点删除");
            }
        } else if (keeperState == Event.KeeperState.Disconnected) {
            System.out.println(logPrefix + "与服务器断开连接");
        } else if (keeperState == Event.KeeperState.AuthFailed) {
            System.out.println(logPrefix + "权限检查失败");
        } else if (keeperState == Event.KeeperState.Expired) {
            System.out.println(logPrefix + "会话失效");
        } else {
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZooKeeperWatcher zooKeeperWatcher = new ZooKeeperWatcher();
        zooKeeperWatcher.createConnection(CONNECTION_ADDRESS, SESSION_TIMEOUT);
        Thread.sleep(1000);
    }
}
