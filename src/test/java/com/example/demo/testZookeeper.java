package com.example.demo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by M93349 on 2020/8/26.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class testZookeeper {
  @Test
  @DisplayName(" Test positive integer Addition")
  public void testData() {
    try {
      ZooKeeper client= new ZooKeeper("10.169.42.200", 2000, new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
          System.out.println("Watch");
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
