package com.example.demo.ZooKeeperUtil;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by M93349 on 2020/8/27.
 */
public class ZKConnection {
  private ZooKeeper zoo;
  final CountDownLatch connectionLatch = new CountDownLatch(1);

  public ZKConnection() {
  }

  public ZooKeeper connect(String host) throws IOException, InterruptedException {
    zoo = new ZooKeeper(host, 20000, new Watcher() {
      public void process(WatchedEvent we) {
        if (we.getState() == Event.KeeperState.SyncConnected) {
          connectionLatch.countDown();
        }
      }
    });
    connectionLatch.await();
    return zoo;
  }

  public void close() throws InterruptedException {
    zoo.close();
  }
}
