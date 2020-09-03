package com.example.demo.CodeGenerator;

import com.example.demo.ZooKeeperUtil.ZKManagerImpl;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by M93349 on 2020/8/26.
 */
public class TestZookeeper {
  public static void main(String[] args) {
    String CONNECT_STRING = "127.0.0.1:2181";

    ZKManagerImpl zk = new ZKManagerImpl(CONNECT_STRING);
    try {
      Object obj =zk.getZNodeData("/zookeeper/hema", true);
      System.out.println(obj);
    }  catch (Exception e) {
      e.printStackTrace();
    }

  }
}
