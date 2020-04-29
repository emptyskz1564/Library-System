package com.liu.library.service.Impl;


import com.alibaba.fastjson.JSONArray;
import com.liu.library.service.RedisService;
import com.liu.library.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @作者：柳景兴
 * @时间：2020-3-21
 * @描述：Java链接Redis服务器并从Redis中存取数据
 */
@Service("redisServiceImpl")
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 根据键获取单个pojo对象
     * @param
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    @Override
    public <T> T get( String key, Class<T> clazz) {
        Jedis jedis = null;
        T t = null;
        try {
            jedis = jedisPool.getResource();
            String result = jedis.get( key);
            t = ConvertUtil.string2Bean(result, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeJedis(jedis);
            return t;
        }
    }

    /**
     * 根据键获取pojo集合对象
     * @param
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    @Override
    public <T> List<T> getArray(String key, Class<T> clazz) {
        Jedis jedis = null;
        List<T> list = null;
        try {
            jedis = jedisPool.getResource();
            String result = jedis.get(key);
            list = JSONArray.parseArray(result, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeJedis(jedis);
            return list;
        }
    }

    /**
     * 根据键设置pojo对象，或者pojo集合
     * @param
     * @param key
     * @param item
     * @param <T>
     * @return
     */
    @Override
    public <T> boolean set(String key, T item) {
        Jedis jedis = null;
        boolean success = false;
        try {
            jedis = jedisPool.getResource();
            String result = ConvertUtil.bean2String(item);
            if (result == null || result.length() <= 0) {
                success = false;
            } else {
                success = true;
            }
            jedis.set( key, result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeJedis(jedis);
            return success;
        }
    }

    /**
     * 结束后关闭Jedis
     * @param jedis
     */
    @Override
    public void closeJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
