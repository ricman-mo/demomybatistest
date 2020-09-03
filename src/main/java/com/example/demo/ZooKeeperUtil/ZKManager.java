package com.example.demo.ZooKeeperUtil;
import org.apache.zookeeper.KeeperException;
/**
 * Created by M93349 on 2020/8/27.
 */
public interface ZKManager {
  /**
   * Create a Znode and save some data
   *
   * @param path
   * @param data
   * @throws KeeperException
   * @throws InterruptedException
   */
  public void create(String path, byte[] data) throws KeeperException, InterruptedException;

  /**
   * Get ZNode Data
   *
   * @param path
   * @throws KeeperException
   * @throws InterruptedException
   */
  public Object getZNodeData(String path, boolean watchFlag);

  /**
   * Update the ZNode Data
   *
   * @param path
   * @param data
   * @throws KeeperException
   * @throws InterruptedException
   */
  public void update(String path, byte[] data) throws KeeperException, InterruptedException, KeeperException;
}
