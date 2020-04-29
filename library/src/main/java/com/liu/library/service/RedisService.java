package com.liu.library.service;

import redis.clients.jedis.Jedis;

import java.util.List;

public interface RedisService {
    public <T> T get(String key, Class<T> clazz);
    public <T> List<T> getArray( String key, Class<T> clazz);
    public <T> boolean set( String key, T item);
    public void closeJedis(Jedis jedis);
}
