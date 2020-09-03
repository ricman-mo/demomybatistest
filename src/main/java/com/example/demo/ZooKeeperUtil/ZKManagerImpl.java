package com.example.demo.ZooKeeperUtil;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by M93349 on 2020/8/27.
 */
public class ZKManagerImpl implements ZKManager  {
  private static ZooKeeper zkeeper;
  private static ZKConnection zkConnection;

  public ZKManagerImpl(String zookeeperHost) {
    initialize(zookeeperHost);
  }

  /** * Initialize connection */
  private void initialize(String zookeeperHost) {
    try {
      zkConnection = new ZKConnection();
      zkeeper = zkConnection.connect(zookeeperHost);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void closeConnection() {
    try {
      zkConnection.close();
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }

  public void create(String path, byte[] data) throws KeeperException, InterruptedException {
    zkeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
  }

  public Object getZNodeData(String path, boolean watchFlag) {
    try {
      byte[] b = null;
      b = zkeeper.getData(path, null, null);
      String data = new String(b, "UTF-8");
      System.out.println(data);
      return data;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public void update(String path, byte[] data) throws KeeperException, InterruptedException {
    int version = zkeeper.exists(path, true)
      .getVersion();
    zkeeper.setData(path, data, version);
  }
}
