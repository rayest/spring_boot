package com.rayeston.zooKeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * Created by lirui on 2017/11/20.
 */
public class Master implements Watcher {

    private ZooKeeper zooKeeper;
    private String hostPort;

    Random random = new Random();
    String serverId = Integer.toHexString(random.nextInt());
    static boolean isLeader = false;

    private boolean checkMaster() throws KeeperException, InterruptedException {
        while (true) {
            try {
                Stat stat = new Stat();
                byte[] data = zooKeeper.getData("/master", false, stat);
                isLeader = new String(data).equals(serverId);
                return true;
            } catch (KeeperException.NoNodeException e) {
                return false;
            } catch (KeeperException.ConnectionLossException e) {
                e.printStackTrace();
            }
        }
    }


    private void runForMaster() throws InterruptedException, KeeperException {
        try {
            zooKeeper.create("/master", serverId.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            isLeader = true;
        } catch (KeeperException.NodeExistsException e) {
            isLeader = false;
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        if (checkMaster()){
        }

    }


    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    private void startZooKeeper() throws IOException {
        zooKeeper = new ZooKeeper(hostPort, 15000, this);
    }

    private void stopZooKeeper() throws InterruptedException {
        zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        Master master = new Master("127.0.0.1:2181");
        master.startZooKeeper();
        master.runForMaster();
        if (isLeader){
            System.out.println("is leader");
        Thread.sleep(60000);
        }else {
            System.out.println("not leader");
        }
        master.stopZooKeeper();
    }


}
