package com.example.demo.config.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * Created by M93349 on 2020/8/21.
 * 重写Shiro缓存管理器
 */
public class CustomShiroCacheManager implements CacheManager {
  @Override
  public <K, V> Cache<K, V> getCache(String s) throws CacheException {
    return new CustomShiroCache<K,V>();
  }
}
